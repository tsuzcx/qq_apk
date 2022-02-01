import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class adft
  implements BusinessObserver
{
  adft(adfo paramadfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d(adfo.jdField_a_of_type_JavaLangString, 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
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
          adhh.a(this.jdField_a_of_type_Adfo.jdField_a_of_type_Adea, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(adfo.jdField_a_of_type_JavaLangString, 2, "parse do auth result error: \n" + paramBundle.getMessage());
        }
        adhh.a(this.jdField_a_of_type_Adfo.jdField_a_of_type_Adea, -2, "parse do auth result error");
        return;
      }
      localObject = new adfn();
      ((adfn)localObject).jdField_a_of_type_JavaLangString = paramBundle.openid.get().toUpperCase();
      ((adfn)localObject).b = paramBundle.access_token.get().toUpperCase();
      paramBundle = paramBundle.callbackURL.get();
      if (QLog.isColorLevel()) {}
      adfo.b(this.jdField_a_of_type_Adfo, paramBundle);
      this.jdField_a_of_type_Adfo.jdField_a_of_type_Adfk.a((adfn)localObject);
      adhh.a(this.jdField_a_of_type_Adfo.jdField_a_of_type_Adea, ((adfn)localObject).a());
      return;
    }
    adhh.a(this.jdField_a_of_type_Adfo.jdField_a_of_type_Adea, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adft
 * JD-Core Version:    0.7.0.1
 */