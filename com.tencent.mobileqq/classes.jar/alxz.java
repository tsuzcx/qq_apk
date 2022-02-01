import org.json.JSONException;
import org.json.JSONObject;

public class alxz
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
  
  static alxz a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new alxz();
    }
    alxz localalxz = new alxz();
    try
    {
      localalxz.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localalxz.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localalxz.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localalxz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localalxz.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localalxz.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localalxz.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localalxz.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localalxz.g = paramJSONObject.getString("classifyName");
      localalxz.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localalxz.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localalxz.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localalxz.h = paramJSONObject.getString("trialstartday");
      localalxz.i = paramJSONObject.getString("trialendday");
      return localalxz;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localalxz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxz
 * JD-Core Version:    0.7.0.1
 */