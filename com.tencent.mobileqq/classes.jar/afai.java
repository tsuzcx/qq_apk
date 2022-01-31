import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class afai
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static afai a(afai paramafai)
  {
    afai localafai = new afai();
    if (paramafai != null)
    {
      localafai.jdField_a_of_type_Int = paramafai.jdField_a_of_type_Int;
      localafai.jdField_a_of_type_JavaLangString = paramafai.jdField_a_of_type_JavaLangString;
      localafai.jdField_b_of_type_Int = paramafai.jdField_b_of_type_Int;
      localafai.jdField_b_of_type_JavaLangString = paramafai.jdField_b_of_type_JavaLangString;
      localafai.c = paramafai.c;
    }
    return localafai;
  }
  
  public static afai a(JSONObject paramJSONObject)
  {
    afai localafai = new afai();
    if (paramJSONObject != null)
    {
      localafai.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localafai.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localafai.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localafai.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localafai.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localafai;
  }
  
  public static JSONObject a(afai paramafai)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramafai != null) {}
    try
    {
      localJSONObject.put("tab_id", paramafai.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramafai.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramafai.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramafai.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramafai.c);
      return localJSONObject;
    }
    catch (JSONException paramafai) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof afai)) {
      return this.jdField_a_of_type_Int == ((afai)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afai
 * JD-Core Version:    0.7.0.1
 */