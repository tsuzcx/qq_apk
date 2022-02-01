import org.json.JSONObject;

public class aaso
{
  public String a;
  public String b;
  
  public aaso(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaso
 * JD-Core Version:    0.7.0.1
 */