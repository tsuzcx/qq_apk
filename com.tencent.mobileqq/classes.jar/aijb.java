import org.json.JSONException;
import org.json.JSONObject;

public class aijb
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
  
  static aijb a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new aijb();
    }
    aijb localaijb = new aijb();
    try
    {
      localaijb.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localaijb.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localaijb.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localaijb.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localaijb.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localaijb.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localaijb.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localaijb.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localaijb.g = paramJSONObject.getString("classifyName");
      localaijb.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localaijb.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localaijb.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localaijb.h = paramJSONObject.getString("trialstartday");
      localaijb.i = paramJSONObject.getString("trialendday");
      return localaijb;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localaijb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijb
 * JD-Core Version:    0.7.0.1
 */