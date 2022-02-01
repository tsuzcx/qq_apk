import org.json.JSONObject;

public class aaio
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public aaio(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("iconGrid");
    this.c = paramJSONObject.optString("jumpUrl");
    this.d = paramJSONObject.optString("iconLoveGrid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaio
 * JD-Core Version:    0.7.0.1
 */