import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class abty
  implements BusinessObserver
{
  abty(abtt paramabtt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d(abtt.jdField_a_of_type_JavaLangString, 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
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
          abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(abtt.jdField_a_of_type_JavaLangString, 2, "parse do auth result error: \n" + paramBundle.getMessage());
        }
        abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, -2, "parse do auth result error");
        return;
      }
      localObject = new abts();
      ((abts)localObject).jdField_a_of_type_JavaLangString = paramBundle.openid.get().toUpperCase();
      ((abts)localObject).b = paramBundle.access_token.get().toUpperCase();
      paramBundle = paramBundle.callbackURL.get();
      if (QLog.isColorLevel()) {}
      abtt.b(this.jdField_a_of_type_Abtt, paramBundle);
      this.jdField_a_of_type_Abtt.jdField_a_of_type_Abtp.a((abts)localObject);
      abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, ((abts)localObject).a());
      return;
    }
    abvm.a(this.jdField_a_of_type_Abtt.jdField_a_of_type_Absf, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abty
 * JD-Core Version:    0.7.0.1
 */