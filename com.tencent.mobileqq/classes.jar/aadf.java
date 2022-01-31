import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aadf
  implements BusinessObserver
{
  aadf(aada paramaada, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d(aada.jdField_a_of_type_JavaLangString, 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
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
          aaet.a(this.jdField_a_of_type_Aada.jdField_a_of_type_Aabm, paramInt, (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(aada.jdField_a_of_type_JavaLangString, 2, "parse do auth result error: \n" + paramBundle.getMessage());
        }
        aaet.a(this.jdField_a_of_type_Aada.jdField_a_of_type_Aabm, -2, "parse do auth result error");
        return;
      }
      localObject = new aacz();
      ((aacz)localObject).jdField_a_of_type_JavaLangString = paramBundle.openid.get().toUpperCase();
      ((aacz)localObject).b = paramBundle.access_token.get().toUpperCase();
      paramBundle = paramBundle.callbackURL.get();
      if (QLog.isColorLevel()) {}
      aada.b(this.jdField_a_of_type_Aada, paramBundle);
      this.jdField_a_of_type_Aada.jdField_a_of_type_Aacw.a((aacz)localObject);
      aaet.a(this.jdField_a_of_type_Aada.jdField_a_of_type_Aabm, ((aacz)localObject).a());
      return;
    }
    aaet.a(this.jdField_a_of_type_Aada.jdField_a_of_type_Aabm, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadf
 * JD-Core Version:    0.7.0.1
 */