public class akjb
{
  public String a;
  
  public akjb(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjb
 * JD-Core Version:    0.7.0.1
 */