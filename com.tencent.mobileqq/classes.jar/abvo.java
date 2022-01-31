import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public final class abvo
  extends RecyclablePool.Recyclable
{
  public long a;
  public String a;
  public long[] a;
  public long b;
  public long c;
  
  public abvo()
  {
    this.jdField_a_of_type_ArrayOfLong = new long[6];
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      this.jdField_a_of_type_ArrayOfLong[i] = 0L;
      i += 1;
    }
    this.c = 0L;
  }
  
  public void recycle()
  {
    super.recycle();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abvo
 * JD-Core Version:    0.7.0.1
 */