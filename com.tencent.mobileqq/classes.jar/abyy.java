import android.text.TextUtils;
import org.json.JSONObject;

public class abyy
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  
  public static abyy a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    abyy localabyy = new abyy();
    try
    {
      paramString = new JSONObject(paramString);
      localabyy.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localabyy.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localabyy.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localabyy.jdField_a_of_type_JavaLangString = paramString.optString("strRecNick");
      localabyy.jdField_b_of_type_JavaLangString = paramString.optString("strRecUin");
      localabyy.jdField_c_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localabyy.jdField_d_of_type_JavaLangString = paramString.optString("strConfessorDesc");
      localabyy.e = paramString.optString("strConfessorNick");
      localabyy.jdField_d_of_type_Int = paramString.optInt("flag");
      localabyy.jdField_a_of_type_Long = paramString.optInt("confessTime");
      return localabyy;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("nTopicId", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("nBGType", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("nConfessorSex", this.jdField_c_of_type_Int);
      ((JSONObject)localObject).put("strRecNick", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("strRecUin", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorUin", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorDesc", this.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorNick", this.e);
      ((JSONObject)localObject).put("flag", this.jdField_d_of_type_Int);
      ((JSONObject)localObject).put("confessTime", this.jdField_a_of_type_Long);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyy
 * JD-Core Version:    0.7.0.1
 */