import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class agtf
{
  public JSONArray a = new JSONArray();
  
  public static agtf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    agtf localagtf = new agtf();
    localagtf.a = a(new JSONObject(paramString));
    return localagtf;
  }
  
  private static JSONArray a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    paramJSONObject = paramJSONObject.optJSONArray("module_config");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localJSONArray.put(paramJSONObject.optJSONObject(i));
      i += 1;
    }
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */