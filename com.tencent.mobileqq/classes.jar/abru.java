import android.text.TextUtils;
import org.json.JSONObject;

public class abru
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
  
  public static abru a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    abru localabru = new abru();
    try
    {
      paramString = new JSONObject(paramString);
      localabru.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localabru.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localabru.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localabru.jdField_a_of_type_JavaLangString = paramString.optString("strRecNick");
      localabru.jdField_b_of_type_JavaLangString = paramString.optString("strRecUin");
      localabru.jdField_c_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localabru.jdField_d_of_type_JavaLangString = paramString.optString("strConfessorDesc");
      localabru.e = paramString.optString("strConfessorNick");
      localabru.jdField_d_of_type_Int = paramString.optInt("flag");
      localabru.jdField_a_of_type_Long = paramString.optInt("confessTime");
      return localabru;
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
 * Qualified Name:     abru
 * JD-Core Version:    0.7.0.1
 */