import org.json.JSONObject;

public class abai
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public static abai a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      abai localabai = new abai();
      paramString = new JSONObject(paramString);
      localabai.a = paramString.optString("icon_image_url", "");
      localabai.b = paramString.optString("md5", "");
      localabai.c = paramString.optString("widget_id", "");
      return localabai;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "k = icon_image_url, value = " + this.a + "\n k = md5, value = " + this.b + "\n k = widget_id, value = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abai
 * JD-Core Version:    0.7.0.1
 */