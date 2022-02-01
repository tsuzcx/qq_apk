import org.json.JSONException;
import org.json.JSONObject;

public class aleo
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
  
  static aleo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new aleo();
    }
    aleo localaleo = new aleo();
    try
    {
      localaleo.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localaleo.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localaleo.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localaleo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localaleo.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localaleo.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localaleo.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localaleo.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localaleo.g = paramJSONObject.getString("classifyName");
      localaleo.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localaleo.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localaleo.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localaleo.h = paramJSONObject.getString("trialstartday");
      localaleo.i = paramJSONObject.getString("trialendday");
      return localaleo;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localaleo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleo
 * JD-Core Version:    0.7.0.1
 */