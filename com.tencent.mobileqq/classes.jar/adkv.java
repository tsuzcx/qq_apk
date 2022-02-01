import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.AccountManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adkv
  extends WtloginObserver
{
  public adkv(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void onAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms DevlockInfo.TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount);
      }
      if (paramDevlockInfo.TimeLimit <= 0) {
        paramDevlockInfo.TimeLimit = 60;
      }
      AuthDevVerifyCodeActivity.a(this.a, paramDevlockInfo.TimeLimit);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms  errMsg:" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.a.a(paramErrMsg.getMessage(), 1);
      return;
    }
    paramWUserSigInfo = this.a.getString(2131716463);
    this.a.a(paramWUserSigInfo, 1);
  }
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnCheckDevLockSms ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnCheckDevLockSms  errMsg:" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevVerifyCodeActivity.a(this.a);
    if (paramInt == 0)
    {
      paramWUserSigInfo = (AccountManager)this.a.app.getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(this.a.app.getCurrentAccountUin(), null);
      }
      asll.a().a(null, this.a.app.getCurrentAccountUin(), 9);
      this.a.setResult(-1);
      this.a.finish();
      paramErrMsg = (AppInterface)AuthDevVerifyCodeActivity.a(this.a).get();
      paramWUserSigInfo = "";
      if (paramErrMsg != null) {
        paramWUserSigInfo = paramErrMsg.getAccount();
      }
      asll.a().a(paramErrMsg, this.a, paramWUserSigInfo, true);
      return;
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.a.a(paramErrMsg.getMessage(), 1);
      return;
    }
    this.a.a(2131716503, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkv
 * JD-Core Version:    0.7.0.1
 */