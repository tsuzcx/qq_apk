import android.support.v4.util.SparseArrayCompat;

public class almh
{
  private static final almh jdField_a_of_type_Almh = new almh();
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<allt> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static almh a()
  {
    return jdField_a_of_type_Almh;
  }
  
  public int a(allt paramallt)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null) || (this.jdField_a_of_type_Int == 0));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, paramallt);
      int i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.delete(paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      allt localallt = (allt)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localallt != null) {
        localallt.a(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     almh
 * JD-Core Version:    0.7.0.1
 */