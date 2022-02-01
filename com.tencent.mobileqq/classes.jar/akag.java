public class akag
  extends akac
{
  private String a;
  
  public akag(String paramString)
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
 * Qualified Name:     akag
 * JD-Core Version:    0.7.0.1
 */