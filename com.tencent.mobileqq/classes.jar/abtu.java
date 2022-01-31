import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

class abtu
  implements BusinessObserver
{
  abtu(abtt paramabtt, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.GetAuthApiListResponse();
      try
      {
        paramBundle = (SdkAuthorize.GetAuthApiListResponse)((SdkAuthorize.GetAuthApiListResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
        paramInt = paramBundle.ret.get();
        localObject = paramBundle.msg.get();
        if (paramInt != 0)
        {
          abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(abtt.jdField_a_of_type_JavaLangString, 2, "parse auth info error: \n" + paramBundle.getMessage());
        }
        abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, -1, "parse auth info error");
        return;
      }
      localObject = (SdkAuthorize.AuthorizeResponse)paramBundle.auth_response.get();
      if ((!abvh.jdField_a_of_type_Boolean) && (abtt.a(this.jdField_a_of_type_Abtt, paramBundle)) && (localObject != null) && (((SdkAuthorize.AuthorizeResponse)localObject).has()))
      {
        paramBundle = new abts();
        paramBundle.jdField_a_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).openid.get().toUpperCase();
        paramBundle.jdField_b_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).access_token.get().toUpperCase();
        paramBundle.jdField_a_of_type_Long = ((SdkAuthorize.AuthorizeResponse)localObject).expires_in.get();
        paramBundle.jdField_b_of_type_Long = (paramBundle.jdField_a_of_type_Long + System.currentTimeMillis());
        this.jdField_a_of_type_Abtt.jdField_a_of_type_Abtp.a(paramBundle);
        abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, paramBundle.a());
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        abtt.a(this.jdField_a_of_type_Abtt);
        return;
      }
      paramBundle = "";
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_Abtt.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bezj)this.jdField_a_of_type_Abtt.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramBundle = paramBundle + ((bezj)localObject).jdField_a_of_type_JavaLangString + "\n";
        paramInt += 1;
      }
      abtt.a(this.jdField_a_of_type_Abtt, paramBundle);
      return;
    }
    abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, paramInt, "get auth info failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtu
 * JD-Core Version:    0.7.0.1
 */