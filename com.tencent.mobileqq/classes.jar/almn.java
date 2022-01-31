import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class almn
{
  private int jdField_a_of_type_Int = 1;
  private almp jdField_a_of_type_Almp;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new almo(this);
  private SparseArray<almk> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((almk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    almk localalmk1 = (almk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    almk localalmk2 = (almk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localalmk1.a(false, null);
    localalmk2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, almk paramalmk)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramalmk);
  }
  
  public void a(int paramInt, almp paramalmp)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Almp = paramalmp;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Almp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     almn
 * JD-Core Version:    0.7.0.1
 */