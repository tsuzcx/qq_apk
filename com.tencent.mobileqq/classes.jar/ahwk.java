import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ahwk
{
  public List<ahwl> a = new ArrayList();
  
  public static ahwk a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new ahwk();
    }
    for (;;)
    {
      return paramJSONObject;
      localahwk = new ahwk();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localahwk;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localahwk;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localahwk;
          if (i >= j) {
            break;
          }
          paramJSONObject = ahwl.a(localJSONArray.getJSONObject(i));
          localahwk.a.add(paramJSONObject);
          i += 1;
        }
        return localahwk;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localahwk;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localahwk;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahwk
 * JD-Core Version:    0.7.0.1
 */