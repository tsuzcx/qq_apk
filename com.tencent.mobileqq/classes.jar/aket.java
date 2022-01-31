import java.util.Comparator;
import org.json.JSONObject;

class aket
  implements Comparator<JSONObject>
{
  aket(akes paramakes) {}
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return Long.valueOf(paramJSONObject2.optLong("time")).compareTo(Long.valueOf(paramJSONObject1.optLong("time")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aket
 * JD-Core Version:    0.7.0.1
 */