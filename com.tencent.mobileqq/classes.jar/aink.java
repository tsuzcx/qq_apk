import java.util.Comparator;
import org.json.JSONObject;

class aink
  implements Comparator<JSONObject>
{
  aink(ainj paramainj) {}
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return Long.valueOf(paramJSONObject2.optLong("time")).compareTo(Long.valueOf(paramJSONObject1.optLong("time")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aink
 * JD-Core Version:    0.7.0.1
 */