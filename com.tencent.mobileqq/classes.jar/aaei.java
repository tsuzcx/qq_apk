import org.json.JSONObject;

public class aaei
  extends JSONObject
{
  public aaei(aaeg paramaaeg, String paramString)
  {
    super(paramString);
  }
  
  public int getInt(String paramString)
  {
    if (!has(paramString)) {
      return 0;
    }
    return super.getInt(paramString);
  }
  
  public String getString(String paramString)
  {
    if (!has(paramString)) {
      return "";
    }
    return super.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaei
 * JD-Core Version:    0.7.0.1
 */