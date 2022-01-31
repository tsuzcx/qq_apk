import org.json.JSONObject;

public class ajaz
  implements ajbn
{
  private int a;
  
  public ajaz()
  {
    int i = ajbm.a;
    ajbm.a = i + 1;
    this.a = i;
  }
  
  public String a()
  {
    return null;
  }
  
  public JSONObject a(ajbm paramajbm, JSONObject paramJSONObject)
  {
    if ("cs.audio_create.local".equals(paramJSONObject.optString("N_R_CMD")))
    {
      paramJSONObject = new ajam(paramJSONObject.optInt("N_R_OBJ"), paramJSONObject.optInt("id"), paramJSONObject.optString("type"));
      if (paramajbm != null) {
        paramajbm.a(paramJSONObject);
      }
    }
    return null;
  }
  
  public int c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajaz
 * JD-Core Version:    0.7.0.1
 */