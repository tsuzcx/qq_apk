public class agwp
  implements bcms
{
  public String a;
  
  public agwp(String paramString)
  {
    this.a = paramString;
  }
  
  public long a()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwp
 * JD-Core Version:    0.7.0.1
 */