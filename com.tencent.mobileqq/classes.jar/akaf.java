public class akaf
  extends akac
{
  private String a;
  
  public akaf(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return String.format("&mqquin=%s", new Object[] { this.a });
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("plg_uin=1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaf
 * JD-Core Version:    0.7.0.1
 */