import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alen
{
  public List<aleo> a = new ArrayList();
  
  public static alen a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new alen();
    }
    for (;;)
    {
      return paramJSONObject;
      localalen = new alen();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localalen;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localalen;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localalen;
          if (i >= j) {
            break;
          }
          paramJSONObject = aleo.a(localJSONArray.getJSONObject(i));
          localalen.a.add(paramJSONObject);
          i += 1;
        }
        return localalen;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localalen;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localalen;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alen
 * JD-Core Version:    0.7.0.1
 */