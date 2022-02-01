import org.json.JSONObject;

public class aasq
{
  public int a;
  public aasl a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public aasq(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("tabID");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("jumpUrl");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("width");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("height");
    if (paramJSONObject.optJSONObject("aioActivityBubble") != null) {
      this.jdField_a_of_type_Aasl = new aasl(paramJSONObject.optJSONObject("aioActivityBubble"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasq
 * JD-Core Version:    0.7.0.1
 */