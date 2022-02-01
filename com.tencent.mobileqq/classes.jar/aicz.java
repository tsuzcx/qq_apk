import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class aicz
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static aicz a(aicz paramaicz)
  {
    aicz localaicz = new aicz();
    if (paramaicz != null)
    {
      localaicz.jdField_a_of_type_Int = paramaicz.jdField_a_of_type_Int;
      localaicz.jdField_a_of_type_JavaLangString = paramaicz.jdField_a_of_type_JavaLangString;
      localaicz.jdField_b_of_type_Int = paramaicz.jdField_b_of_type_Int;
      localaicz.jdField_b_of_type_JavaLangString = paramaicz.jdField_b_of_type_JavaLangString;
      localaicz.c = paramaicz.c;
    }
    return localaicz;
  }
  
  public static aicz a(JSONObject paramJSONObject)
  {
    aicz localaicz = new aicz();
    if (paramJSONObject != null)
    {
      localaicz.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localaicz.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localaicz.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localaicz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localaicz.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localaicz;
  }
  
  public static JSONObject a(aicz paramaicz)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramaicz != null) {}
    try
    {
      localJSONObject.put("tab_id", paramaicz.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramaicz.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramaicz.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramaicz.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramaicz.c);
      return localJSONObject;
    }
    catch (JSONException paramaicz) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof aicz)) {
      return this.jdField_a_of_type_Int == ((aicz)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicz
 * JD-Core Version:    0.7.0.1
 */