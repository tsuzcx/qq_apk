public class agef
{
  public String a;
  
  public agef(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keyword = ").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agef
 * JD-Core Version:    0.7.0.1
 */