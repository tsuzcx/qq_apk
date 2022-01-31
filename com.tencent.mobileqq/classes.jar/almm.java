import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class almm
{
  private int jdField_a_of_type_Int = 1;
  private almo jdField_a_of_type_Almo;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new almn(this);
  private SparseArray<almj> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((almj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    almj localalmj1 = (almj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    almj localalmj2 = (almj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localalmj1.a(false, null);
    localalmj2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, almj paramalmj)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramalmj);
  }
  
  public void a(int paramInt, almo paramalmo)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Almo = paramalmo;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Almo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     almm
 * JD-Core Version:    0.7.0.1
 */