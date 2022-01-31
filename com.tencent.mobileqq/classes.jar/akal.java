import org.json.JSONException;
import org.json.JSONObject;

public class akal
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
  
  static akal a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new akal();
    }
    akal localakal = new akal();
    try
    {
      localakal.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localakal.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localakal.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localakal.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localakal.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localakal.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localakal.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localakal.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localakal.g = paramJSONObject.getString("classifyName");
      localakal.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localakal.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localakal.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localakal.h = paramJSONObject.getString("trialstartday");
      localakal.i = paramJSONObject.getString("trialendday");
      return localakal;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localakal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akal
 * JD-Core Version:    0.7.0.1
 */