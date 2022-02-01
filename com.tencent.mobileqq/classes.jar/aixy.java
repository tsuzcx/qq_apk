import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class aixy
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static aixy a(aixy paramaixy)
  {
    aixy localaixy = new aixy();
    if (paramaixy != null)
    {
      localaixy.jdField_a_of_type_Int = paramaixy.jdField_a_of_type_Int;
      localaixy.jdField_a_of_type_JavaLangString = paramaixy.jdField_a_of_type_JavaLangString;
      localaixy.jdField_b_of_type_Int = paramaixy.jdField_b_of_type_Int;
      localaixy.jdField_b_of_type_JavaLangString = paramaixy.jdField_b_of_type_JavaLangString;
      localaixy.c = paramaixy.c;
    }
    return localaixy;
  }
  
  public static aixy a(JSONObject paramJSONObject)
  {
    aixy localaixy = new aixy();
    if (paramJSONObject != null)
    {
      localaixy.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localaixy.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localaixy.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localaixy.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localaixy.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localaixy;
  }
  
  public static JSONObject a(aixy paramaixy)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramaixy != null) {}
    try
    {
      localJSONObject.put("tab_id", paramaixy.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramaixy.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramaixy.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramaixy.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramaixy.c);
      return localJSONObject;
    }
    catch (JSONException paramaixy) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof aixy)) {
      return this.jdField_a_of_type_Int == ((aixy)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixy
 * JD-Core Version:    0.7.0.1
 */