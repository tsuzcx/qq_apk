import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aijc
{
  public List<aijd> a = new ArrayList();
  
  public static aijc a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new aijc();
    }
    for (;;)
    {
      return paramJSONObject;
      localaijc = new aijc();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localaijc;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localaijc;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localaijc;
          if (i >= j) {
            break;
          }
          paramJSONObject = aijd.a(localJSONArray.getJSONObject(i));
          localaijc.a.add(paramJSONObject);
          i += 1;
        }
        return localaijc;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localaijc;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localaijc;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijc
 * JD-Core Version:    0.7.0.1
 */