import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.login.GatewayVerify.PicVerifyInfo;
import tencent.im.login.GatewayVerify.ReqBindPhoneLogin;
import tencent.im.login.GatewayVerify.ReqBody;

public class aexo
  extends MqqHandler
{
  public aexo(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2014: 
      this.a.finish();
      return;
    case 2015: 
      this.a.finish();
      return;
    }
    QLog.d("LoginPhoneNumActivity", 1, "fangshuiqiang ticket return");
    Object localObject = (Bundle)paramMessage.obj;
    paramMessage = ((Bundle)localObject).getString("ticket", "");
    String str = ((Bundle)localObject).getString("randstr", "");
    localObject = ((Bundle)localObject).getString("appid", "0");
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.bytes_verify_sig.set(ByteStringMicro.copyFromUtf8(paramMessage));
    localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.bytes_rand_key.set(ByteStringMicro.copyFromUtf8(str));
    localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.uint64_appid.set(Long.parseLong((String)localObject));
    localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.setHasFlag(true);
    localReqBody.msg_req_bind_phone_login.setHasFlag(true);
    localReqBody.setHasFlag(true);
    LoginPhoneNumActivity.a(this.a, localReqBody.toByteArray());
    LoginPhoneNumActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexo
 * JD-Core Version:    0.7.0.1
 */