import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class aixh
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static aixh a(aixh paramaixh)
  {
    aixh localaixh = new aixh();
    if (paramaixh != null)
    {
      localaixh.jdField_a_of_type_Int = paramaixh.jdField_a_of_type_Int;
      localaixh.jdField_a_of_type_JavaLangString = paramaixh.jdField_a_of_type_JavaLangString;
      localaixh.jdField_b_of_type_Int = paramaixh.jdField_b_of_type_Int;
      localaixh.jdField_b_of_type_JavaLangString = paramaixh.jdField_b_of_type_JavaLangString;
      localaixh.c = paramaixh.c;
    }
    return localaixh;
  }
  
  public static aixh a(JSONObject paramJSONObject)
  {
    aixh localaixh = new aixh();
    if (paramJSONObject != null)
    {
      localaixh.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localaixh.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localaixh.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localaixh.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localaixh.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localaixh;
  }
  
  public static JSONObject a(aixh paramaixh)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramaixh != null) {}
    try
    {
      localJSONObject.put("tab_id", paramaixh.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramaixh.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramaixh.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramaixh.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramaixh.c);
      return localJSONObject;
    }
    catch (JSONException paramaixh) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof aixh)) {
      return this.jdField_a_of_type_Int == ((aixh)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixh
 * JD-Core Version:    0.7.0.1
 */