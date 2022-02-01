import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alxy
{
  public List<alxz> a = new ArrayList();
  
  public static alxy a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new alxy();
    }
    for (;;)
    {
      return paramJSONObject;
      localalxy = new alxy();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localalxy;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localalxy;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localalxy;
          if (i >= j) {
            break;
          }
          paramJSONObject = alxz.a(localJSONArray.getJSONObject(i));
          localalxy.a.add(paramJSONObject);
          i += 1;
        }
        return localalxy;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localalxy;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localalxy;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxy
 * JD-Core Version:    0.7.0.1
 */