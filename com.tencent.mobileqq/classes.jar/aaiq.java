import org.json.JSONObject;

public class aaiq
{
  public String a;
  public String b;
  
  public aaiq(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiq
 * JD-Core Version:    0.7.0.1
 */