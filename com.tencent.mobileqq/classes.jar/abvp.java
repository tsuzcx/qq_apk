public final class abvp
{
  public int a;
  public long a;
  public long[] a;
  public long b;
  
  public abvp()
  {
    this.jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L, 0L };
  }
  
  public abvp(long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L, 0L };
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvp
 * JD-Core Version:    0.7.0.1
 */