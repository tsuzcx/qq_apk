import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import org.json.JSONObject;

class aiow
  implements zrt
{
  aiow(aios paramaios, String paramString, long paramLong, zrw paramzrw, CmGameInitParams paramCmGameInitParams) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    aios.a(this.jdField_a_of_type_Aios, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void onPermission(int paramInt)
  {
    aios.a(this.jdField_a_of_type_Aios, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token", "");
    aios.a(this.jdField_a_of_type_Aios, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zrw);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.openId = str;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessToken = paramJSONObject;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 1;
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */