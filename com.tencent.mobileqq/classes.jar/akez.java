import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class akez
{
  public List<akfa> a = new ArrayList();
  
  public static akez a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new akez();
    }
    for (;;)
    {
      return paramJSONObject;
      localakez = new akez();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localakez;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localakez;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localakez;
          if (i >= j) {
            break;
          }
          paramJSONObject = akfa.a(localJSONArray.getJSONObject(i));
          localakez.a.add(paramJSONObject);
          i += 1;
        }
        return localakez;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localakez;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localakez;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akez
 * JD-Core Version:    0.7.0.1
 */