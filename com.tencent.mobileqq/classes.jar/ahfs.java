import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahfs
{
  public JSONArray a = new JSONArray();
  
  public static ahfs a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ahfs localahfs = new ahfs();
    localahfs.a = a(new JSONObject(paramString));
    return localahfs;
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
 * Qualified Name:     ahfs
 * JD-Core Version:    0.7.0.1
 */