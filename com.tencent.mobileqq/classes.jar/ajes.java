public class ajes
  extends ajeo
{
  private String a;
  
  public ajes(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return String.format("&mqqvkey=%s", new Object[] { this.a });
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("plg_vkey=1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajes
 * JD-Core Version:    0.7.0.1
 */