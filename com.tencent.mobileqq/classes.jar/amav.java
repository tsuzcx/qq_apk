import android.support.v4.util.SparseArrayCompat;

public class amav
{
  private static final amav jdField_a_of_type_Amav = new amav();
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<amah> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static amav a()
  {
    return jdField_a_of_type_Amav;
  }
  
  public int a(amah paramamah)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null) || (this.jdField_a_of_type_Int == 0));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, paramamah);
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
      amah localamah = (amah)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localamah != null) {
        localamah.a(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amav
 * JD-Core Version:    0.7.0.1
 */