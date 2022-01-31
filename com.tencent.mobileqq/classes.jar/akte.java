import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import org.json.JSONObject;

class akte
  implements absf
{
  akte(akta paramakta, String paramString, long paramLong, absi paramabsi, CmGameInitParams paramCmGameInitParams) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    akta.a(this.jdField_a_of_type_Akta, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void onPermission(int paramInt)
  {
    akta.a(this.jdField_a_of_type_Akta, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token", "");
    akta.a(this.jdField_a_of_type_Akta, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Absi);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.openId = str;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessToken = paramJSONObject;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 1;
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akte
 * JD-Core Version:    0.7.0.1
 */