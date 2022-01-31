import org.json.JSONException;
import org.json.JSONObject;

public class akfa
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
  
  static akfa a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new akfa();
    }
    akfa localakfa = new akfa();
    try
    {
      localakfa.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localakfa.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localakfa.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localakfa.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localakfa.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localakfa.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localakfa.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localakfa.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localakfa.g = paramJSONObject.getString("classifyName");
      localakfa.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localakfa.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localakfa.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localakfa.h = paramJSONObject.getString("trialstartday");
      localakfa.i = paramJSONObject.getString("trialendday");
      return localakfa;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localakfa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfa
 * JD-Core Version:    0.7.0.1
 */