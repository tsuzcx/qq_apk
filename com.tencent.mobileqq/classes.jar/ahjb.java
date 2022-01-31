import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ahjb
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static ahjb a(ahjb paramahjb)
  {
    ahjb localahjb = new ahjb();
    if (paramahjb != null)
    {
      localahjb.jdField_a_of_type_Int = paramahjb.jdField_a_of_type_Int;
      localahjb.jdField_a_of_type_JavaLangString = paramahjb.jdField_a_of_type_JavaLangString;
      localahjb.jdField_b_of_type_Int = paramahjb.jdField_b_of_type_Int;
      localahjb.jdField_b_of_type_JavaLangString = paramahjb.jdField_b_of_type_JavaLangString;
      localahjb.c = paramahjb.c;
    }
    return localahjb;
  }
  
  public static ahjb a(JSONObject paramJSONObject)
  {
    ahjb localahjb = new ahjb();
    if (paramJSONObject != null)
    {
      localahjb.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localahjb.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localahjb.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localahjb.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localahjb.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localahjb;
  }
  
  public static JSONObject a(ahjb paramahjb)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramahjb != null) {}
    try
    {
      localJSONObject.put("tab_id", paramahjb.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramahjb.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramahjb.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramahjb.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramahjb.c);
      return localJSONObject;
    }
    catch (JSONException paramahjb) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ahjb)) {
      return this.jdField_a_of_type_Int == ((ahjb)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjb
 * JD-Core Version:    0.7.0.1
 */