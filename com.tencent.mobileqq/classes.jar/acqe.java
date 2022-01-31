import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgRsp;
import cooperation.weiyun.sdk.api.IWeiyunCallback;
import cooperation.weiyun.sdk.api.WeiyunApi;
import mqq.app.MobileQQ;

public class acqe
  implements IWeiyunCallback
{
  public acqe(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    WeiYunLogicCenter.a(this.a).a().a(false, 44, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onSucceed  need pwd[" + paramPwdQueryMsgRsp.pwd_open.get() + "]");
    }
    WeiyunApi.a(WeiYunLogicCenter.a(this.a).getApplication().getApplicationContext(), true);
    if (paramPwdQueryMsgRsp.pwd_open.get()) {
      WeiyunApi.b(WeiYunLogicCenter.a(this.a).getApplication().getApplicationContext(), true);
    }
    WeiYunLogicCenter.a(this.a).a().a(true, 44, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(paramPwdQueryMsgRsp.pwd_open.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acqe
 * JD-Core Version:    0.7.0.1
 */