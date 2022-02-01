public class aihl
  implements aiho
{
  private long a;
  private long b;
  
  public long a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void b(long paramLong)
  {
    if (this.a != 0L)
    {
      this.b = (paramLong - this.a + this.b);
      this.a = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihl
 * JD-Core Version:    0.7.0.1
 */