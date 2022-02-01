import org.json.JSONObject;

public class adbe
{
  public int a;
  public String a;
  public String b;
  
  public adbe(adbc paramadbc) {}
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("hookpoint_type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("hookpoint_lib_name").trim();
      this.b = paramJSONObject.getString("hookpoint_func_name").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      adax.a("KingKongNativePatch", "Parse HookPoint error!");
    }
    return false;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbe
 * JD-Core Version:    0.7.0.1
 */