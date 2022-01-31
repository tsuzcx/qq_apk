import org.json.JSONObject;

public class akxa
  implements akxo
{
  private int a;
  
  public akxa()
  {
    int i = akxn.a;
    akxn.a = i + 1;
    this.a = i;
  }
  
  public String a()
  {
    return null;
  }
  
  public JSONObject a(akxn paramakxn, JSONObject paramJSONObject)
  {
    if ("cs.audio_create.local".equals(paramJSONObject.optString("N_R_CMD")))
    {
      paramJSONObject = new akwn(paramJSONObject.optInt("N_R_OBJ"), paramJSONObject.optInt("id"), paramJSONObject.optString("type"));
      if (paramakxn != null) {
        paramakxn.a(paramJSONObject);
      }
    }
    return null;
  }
  
  public int c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxa
 * JD-Core Version:    0.7.0.1
 */