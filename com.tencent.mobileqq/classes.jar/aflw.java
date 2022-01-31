import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class aflw
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static aflw a(aflw paramaflw)
  {
    aflw localaflw = new aflw();
    if (paramaflw != null)
    {
      localaflw.jdField_a_of_type_Int = paramaflw.jdField_a_of_type_Int;
      localaflw.jdField_a_of_type_JavaLangString = paramaflw.jdField_a_of_type_JavaLangString;
      localaflw.jdField_b_of_type_Int = paramaflw.jdField_b_of_type_Int;
      localaflw.jdField_b_of_type_JavaLangString = paramaflw.jdField_b_of_type_JavaLangString;
      localaflw.c = paramaflw.c;
    }
    return localaflw;
  }
  
  public static aflw a(JSONObject paramJSONObject)
  {
    aflw localaflw = new aflw();
    if (paramJSONObject != null)
    {
      localaflw.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localaflw.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localaflw.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localaflw.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localaflw.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localaflw;
  }
  
  public static JSONObject a(aflw paramaflw)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramaflw != null) {}
    try
    {
      localJSONObject.put("tab_id", paramaflw.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramaflw.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramaflw.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramaflw.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramaflw.c);
      return localJSONObject;
    }
    catch (JSONException paramaflw) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof aflw)) {
      return this.jdField_a_of_type_Int == ((aflw)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflw
 * JD-Core Version:    0.7.0.1
 */