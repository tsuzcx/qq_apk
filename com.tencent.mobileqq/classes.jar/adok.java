import android.text.TextUtils;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adok
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  public adok(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  private void a(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvVerifyCode uin:" + paramString + " seq=" + paramInt1);
        if (paramDevlockInfo != null) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvVerifyCode info.TimeLimit:" + paramDevlockInfo.TimeLimit);
        }
      }
      setSeq(paramInt1);
      paramInt2 = 60;
      paramInt1 = paramInt2;
      if (paramDevlockInfo != null)
      {
        paramInt1 = paramInt2;
        if (paramDevlockInfo.TimeLimit > 0) {
          paramInt1 = paramDevlockInfo.TimeLimit;
        }
      }
      AuthDevVerifyCodeActivity.a(this.a, paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvVerifyCode ret = " + paramInt2 + " seq=" + paramInt1);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvVerifyCode  errMsg:" + paramErrMsg.getMessage() + " seq=" + paramInt1);
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      this.a.setResult(-1);
      this.a.finish();
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.a.a(paramErrMsg.getMessage(), 1);
      return;
    }
    paramString = this.a.getString(2131715770);
    this.a.a(paramString, 1);
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevVerifyCodeActivity.a(this.a);
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvCheckSMSResult uin:" + paramString + " seq=" + paramInt1);
      }
      setSeq(paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvCheckSMSResult ret = " + paramInt2 + " seq=" + paramInt1);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvCheckSMSResult  errMsg:" + paramErrMsg.getMessage() + " seq=" + paramInt1);
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      this.a.setResult(-1);
      this.a.finish();
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.a.a(paramErrMsg.getMessage(), 1);
      return;
    }
    paramString = this.a.getString(2131715770);
    this.a.a(paramString, 1);
  }
  
  public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onRecvNotice uin:" + paramString + " seq=" + paramInt1);
    }
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_REFRESH_SMS_RESULT)
    {
      a(paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose ret = " + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose  errMsg:" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose activity is finishing.");
      }
      return;
    }
    this.a.c();
    AuthDevVerifyCodeActivity.a(this.a);
    this.a.setResult(-1);
    this.a.finish();
    asfr.a().a((AppRuntime)AuthDevVerifyCodeActivity.a(this.a).get(), this.a, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adok
 * JD-Core Version:    0.7.0.1
 */