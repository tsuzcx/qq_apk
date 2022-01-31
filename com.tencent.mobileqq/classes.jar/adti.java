import android.os.Bundle;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import mqq.observer.BusinessObserver;

public class adti
  implements BusinessObserver
{
  public adti(LoginKeyHelper paramLoginKeyHelper, LoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    paramBundle = paramBundle.getByteArray("data");
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      FastAuthorize.AuthorizeResponse localAuthorizeResponse = new FastAuthorize.AuthorizeResponse();
      try
      {
        localAuthorizeResponse.mergeFrom(paramBundle);
        if ((localAuthorizeResponse.ret.get().equals("0")) && (localAuthorizeResponse.apk_name.has()))
        {
          if (localAuthorizeResponse.access_token.has()) {
            this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a.jdField_a_of_type_JavaLangString = localAuthorizeResponse.access_token.get();
          }
          if (localAuthorizeResponse.openid.has()) {
            this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a.b = localAuthorizeResponse.openid.get();
          }
          if (localAuthorizeResponse.pay_token.has()) {
            this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a.c = localAuthorizeResponse.pay_token.get();
          }
          this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener.a(this.jdField_a_of_type_JavaLangString, true, 0);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adti
 * JD-Core Version:    0.7.0.1
 */