import android.text.TextUtils;
import org.json.JSONObject;

public class abkt
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
  
  public static abkt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    abkt localabkt = new abkt();
    try
    {
      paramString = new JSONObject(paramString);
      localabkt.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localabkt.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localabkt.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localabkt.jdField_a_of_type_JavaLangString = paramString.optString("strRecNick");
      localabkt.jdField_b_of_type_JavaLangString = paramString.optString("strRecUin");
      localabkt.jdField_c_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localabkt.jdField_d_of_type_JavaLangString = paramString.optString("strConfessorDesc");
      localabkt.e = paramString.optString("strConfessorNick");
      localabkt.jdField_d_of_type_Int = paramString.optInt("flag");
      localabkt.jdField_a_of_type_Long = paramString.optInt("confessTime");
      return localabkt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abkt
 * JD-Core Version:    0.7.0.1
 */