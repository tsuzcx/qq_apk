import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ador
  implements BusinessObserver
{
  ador(adom paramadom, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d(adom.jdField_a_of_type_JavaLangString, 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.AuthorizeResponse();
      try
      {
        paramBundle = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
        paramInt = paramBundle.ret.get();
        localObject = paramBundle.msg.get();
        if (paramInt != 0)
        {
          adqf.a(this.jdField_a_of_type_Adom.jdField_a_of_type_Admy, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(adom.jdField_a_of_type_JavaLangString, 2, "parse do auth result error: \n" + paramBundle.getMessage());
        }
        adqf.a(this.jdField_a_of_type_Adom.jdField_a_of_type_Admy, -2, "parse do auth result error");
        return;
      }
      localObject = new adol();
      ((adol)localObject).jdField_a_of_type_JavaLangString = paramBundle.openid.get().toUpperCase();
      ((adol)localObject).b = paramBundle.access_token.get().toUpperCase();
      paramBundle = paramBundle.callbackURL.get();
      if (QLog.isColorLevel()) {}
      adom.b(this.jdField_a_of_type_Adom, paramBundle);
      this.jdField_a_of_type_Adom.jdField_a_of_type_Adoi.a((adol)localObject);
      adqf.a(this.jdField_a_of_type_Adom.jdField_a_of_type_Admy, ((adol)localObject).a());
      return;
    }
    adqf.a(this.jdField_a_of_type_Adom.jdField_a_of_type_Admy, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ador
 * JD-Core Version:    0.7.0.1
 */