import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import cooperation.weiyun.sdk.api.IWeiyunCallback;
import cooperation.weiyun.sdk.api.WeiyunApi;
import cooperation.weiyun.utils.StringUtils;
import mqq.app.MobileQQ;

public class adac
  implements IWeiyunCallback
{
  public adac(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    WeiYunLogicCenter.a(this.a).a().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    String str = StringUtils.a(paramPwdVerifyMsgRsp.cs_sig.get());
    if (!TextUtils.isEmpty(str)) {
      WeiyunApi.a(WeiYunLogicCenter.a(this.a).getApplication().getApplicationContext(), str);
    }
    WeiyunApi.c(WeiYunLogicCenter.a(this.a).getApplication().getApplicationContext(), true);
    WeiYunLogicCenter.a(this.a).a().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adac
 * JD-Core Version:    0.7.0.1
 */