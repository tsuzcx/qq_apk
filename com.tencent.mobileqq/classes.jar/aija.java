import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aija
{
  public List<aijb> a = new ArrayList();
  
  public static aija a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new aija();
    }
    for (;;)
    {
      return paramJSONObject;
      localaija = new aija();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localaija;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localaija;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localaija;
          if (i >= j) {
            break;
          }
          paramJSONObject = aijb.a(localJSONArray.getJSONObject(i));
          localaija.a.add(paramJSONObject);
          i += 1;
        }
        return localaija;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localaija;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localaija;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aija
 * JD-Core Version:    0.7.0.1
 */