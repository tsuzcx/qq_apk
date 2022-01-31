import org.json.JSONException;
import org.json.JSONObject;

public class aijd
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
  
  static aijd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new aijd();
    }
    aijd localaijd = new aijd();
    try
    {
      localaijd.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localaijd.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localaijd.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localaijd.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localaijd.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localaijd.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localaijd.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localaijd.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localaijd.g = paramJSONObject.getString("classifyName");
      localaijd.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localaijd.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localaijd.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localaijd.h = paramJSONObject.getString("trialstartday");
      localaijd.i = paramJSONObject.getString("trialendday");
      return localaijd;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localaijd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijd
 * JD-Core Version:    0.7.0.1
 */