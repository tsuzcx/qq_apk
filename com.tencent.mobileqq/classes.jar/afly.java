import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class afly
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static afly a(afly paramafly)
  {
    afly localafly = new afly();
    if (paramafly != null)
    {
      localafly.jdField_a_of_type_Int = paramafly.jdField_a_of_type_Int;
      localafly.jdField_a_of_type_JavaLangString = paramafly.jdField_a_of_type_JavaLangString;
      localafly.jdField_b_of_type_Int = paramafly.jdField_b_of_type_Int;
      localafly.jdField_b_of_type_JavaLangString = paramafly.jdField_b_of_type_JavaLangString;
      localafly.c = paramafly.c;
    }
    return localafly;
  }
  
  public static afly a(JSONObject paramJSONObject)
  {
    afly localafly = new afly();
    if (paramJSONObject != null)
    {
      localafly.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localafly.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localafly.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localafly.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localafly.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localafly;
  }
  
  public static JSONObject a(afly paramafly)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramafly != null) {}
    try
    {
      localJSONObject.put("tab_id", paramafly.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramafly.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramafly.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramafly.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramafly.c);
      return localJSONObject;
    }
    catch (JSONException paramafly) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof afly)) {
      return this.jdField_a_of_type_Int == ((afly)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afly
 * JD-Core Version:    0.7.0.1
 */