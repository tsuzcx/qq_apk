import org.json.JSONException;
import org.json.JSONObject;

public class ahwl
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static ahwl a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new ahwl();
    }
    ahwl localahwl = new ahwl();
    try
    {
      localahwl.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localahwl.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localahwl.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localahwl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localahwl.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localahwl.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localahwl.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localahwl.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localahwl.g = paramJSONObject.getString("classifyName");
      localahwl.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localahwl.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localahwl.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localahwl.h = paramJSONObject.getString("trialstartday");
      localahwl.i = paramJSONObject.getString("trialendday");
      return localahwl;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localahwl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahwl
 * JD-Core Version:    0.7.0.1
 */