import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class akyb
{
  private int jdField_a_of_type_Int = 1;
  private akyd jdField_a_of_type_Akyd;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new akyc(this);
  private SparseArray<akxy> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((akxy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    akxy localakxy1 = (akxy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    akxy localakxy2 = (akxy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localakxy1.a(false, null);
    localakxy2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
  }
  
  public void a()
  {
    int i = 1;
    while (i <= 3)
    {
      a(i);
      i += 1;
    }
  }
  
  public void a(int paramInt, akxy paramakxy)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramakxy);
  }
  
  public void a(int paramInt, akyd paramakyd)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Akyd = paramakyd;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Akyd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyb
 * JD-Core Version:    0.7.0.1
 */