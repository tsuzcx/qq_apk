import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class adol
{
  public long a;
  public String a;
  public long b;
  public String b;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openid", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("access_token", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("expire_in", this.jdField_a_of_type_Long);
      localJSONObject.put("expire_time", this.jdField_b_of_type_Long);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(adoi.jdField_a_of_type_JavaLangString, 2, localJSONException.getMessage(), localJSONException);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return "LoginInfo{, openid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", access_token='" + this.jdField_b_of_type_JavaLangString + '\'' + ", expireIn='" + this.jdField_a_of_type_Long + '\'' + ", expireTime='" + this.jdField_b_of_type_Long + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adol
 * JD-Core Version:    0.7.0.1
 */