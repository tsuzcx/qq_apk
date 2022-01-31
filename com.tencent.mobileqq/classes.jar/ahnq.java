import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ahnq
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static ahnq a(ahnq paramahnq)
  {
    ahnq localahnq = new ahnq();
    if (paramahnq != null)
    {
      localahnq.jdField_a_of_type_Int = paramahnq.jdField_a_of_type_Int;
      localahnq.jdField_a_of_type_JavaLangString = paramahnq.jdField_a_of_type_JavaLangString;
      localahnq.jdField_b_of_type_Int = paramahnq.jdField_b_of_type_Int;
      localahnq.jdField_b_of_type_JavaLangString = paramahnq.jdField_b_of_type_JavaLangString;
      localahnq.c = paramahnq.c;
    }
    return localahnq;
  }
  
  public static ahnq a(JSONObject paramJSONObject)
  {
    ahnq localahnq = new ahnq();
    if (paramJSONObject != null)
    {
      localahnq.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localahnq.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localahnq.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localahnq.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localahnq.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localahnq;
  }
  
  public static JSONObject a(ahnq paramahnq)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramahnq != null) {}
    try
    {
      localJSONObject.put("tab_id", paramahnq.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramahnq.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramahnq.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramahnq.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramahnq.c);
      return localJSONObject;
    }
    catch (JSONException paramahnq) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ahnq)) {
      return this.jdField_a_of_type_Int == ((ahnq)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnq
 * JD-Core Version:    0.7.0.1
 */