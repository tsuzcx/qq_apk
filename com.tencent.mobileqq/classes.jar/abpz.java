import org.json.JSONObject;

public class abpz
{
  public int a;
  public String a;
  public String b;
  
  public abpz(abpy paramabpy) {}
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("lib_name").trim();
      this.b = paramJSONObject.getString("func_name").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      abpt.a("KingKongNativePatch", "Parse fingerprint error!");
    }
    return false;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpz
 * JD-Core Version:    0.7.0.1
 */