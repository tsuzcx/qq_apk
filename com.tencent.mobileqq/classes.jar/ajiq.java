import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ajiq
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static ajiq a(ajiq paramajiq)
  {
    ajiq localajiq = new ajiq();
    if (paramajiq != null)
    {
      localajiq.jdField_a_of_type_Int = paramajiq.jdField_a_of_type_Int;
      localajiq.jdField_a_of_type_JavaLangString = paramajiq.jdField_a_of_type_JavaLangString;
      localajiq.jdField_b_of_type_Int = paramajiq.jdField_b_of_type_Int;
      localajiq.jdField_b_of_type_JavaLangString = paramajiq.jdField_b_of_type_JavaLangString;
      localajiq.c = paramajiq.c;
    }
    return localajiq;
  }
  
  public static ajiq a(JSONObject paramJSONObject)
  {
    ajiq localajiq = new ajiq();
    if (paramJSONObject != null)
    {
      localajiq.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localajiq.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localajiq.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localajiq.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localajiq.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localajiq;
  }
  
  public static JSONObject a(ajiq paramajiq)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramajiq != null) {}
    try
    {
      localJSONObject.put("tab_id", paramajiq.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramajiq.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramajiq.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramajiq.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramajiq.c);
      return localJSONObject;
    }
    catch (JSONException paramajiq) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ajiq)) {
      return this.jdField_a_of_type_Int == ((ajiq)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiq
 * JD-Core Version:    0.7.0.1
 */