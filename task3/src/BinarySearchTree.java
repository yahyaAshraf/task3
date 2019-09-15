public class BinarySearchTree { 

	/* Class containing left and right child of current node and key value*/
	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

	// Constructor 
	BinarySearchTree() { 
		root = null; 
	} 

	// This method mainly calls insertRec() 
	void insert(int key) { 
	root = insertRec(root, key); 
	}
 //To search a given key in Binary Search Tree, 
//we first compare it with root, if the key is present at root, we return root.
// If key is greater than root’s key, we recur for right subtree of root node.
// Otherwise we recur for left subtree.

public Node search(Node root, int key) 
{ 
    // Base Cases: root is null or key is present at root 
    if (root==null || root.key==key) 
        return root; 
  
    // val is greater than root's key 
    if (root.key > key) 
        return search(root.left, key); 
  
    // val is less than root's key 
    return search(root.right, key); 
} 
	//insertion

//A new key is always inserted at leaf.
// We start searching a key from root till we hit a leaf node.
// Once a leaf node is found, the new node is added as a child of the leaf node.

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
                //if the value to be inserted is smaller than root value then move to the left side of tree
        if (key < root.key) 
			root.left = insertRec(root.left, key); 
        //otherwise move to the right side of tree 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder() { 
	inorderRec(root); 
	} 

	// A function to do inorder traversal of BST
        // Inorder means printing values from smallest to biggest value 
	void inorderRec(Node root) { 
		if (root != null) { 
                    //so first get to the left side of tree and once reaches at the end start printing them.
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 

	// Driver Program to test above functions 
	public static void main(String[] args) { 
		BinarySearchTree tree = new BinarySearchTree(); 

		
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		// print inorder traversal of the BST 
		tree.inorder(); 
	} 
} 