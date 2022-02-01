import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aawo
{
  public int a;
  public String a;
  public List<aawn> a;
  public int b;
  public String b;
  public int c;
  
  public aawo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("width");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("height");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("lottie");
    this.c = paramJSONObject.optInt("interval");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("jumpUrl");
    if (paramJSONObject.optJSONArray("aioActivities") != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONArray("aioActivities");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        aawn localaawn = new aawn(paramJSONObject.optJSONObject(i));
        this.jdField_a_of_type_JavaUtilList.add(localaawn);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawo
 * JD-Core Version:    0.7.0.1
 */