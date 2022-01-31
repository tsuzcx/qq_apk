import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class akak
{
  public List<akal> a = new ArrayList();
  
  public static akak a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new akak();
    }
    for (;;)
    {
      return paramJSONObject;
      localakak = new akak();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localakak;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localakak;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localakak;
          if (i >= j) {
            break;
          }
          paramJSONObject = akal.a(localJSONArray.getJSONObject(i));
          localakak.a.add(paramJSONObject);
          i += 1;
        }
        return localakak;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localakak;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localakak;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akak
 * JD-Core Version:    0.7.0.1
 */