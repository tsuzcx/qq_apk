import android.support.v4.util.SparseArrayCompat;

public class amau
{
  private static final amau jdField_a_of_type_Amau = new amau();
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<amag> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static amau a()
  {
    return jdField_a_of_type_Amau;
  }
  
  public int a(amag paramamag)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null) || (this.jdField_a_of_type_Int == 0));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, paramamag);
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
      amag localamag = (amag)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localamag != null) {
        localamag.a(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amau
 * JD-Core Version:    0.7.0.1
 */