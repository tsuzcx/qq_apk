import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aabj
  extends WtloginObserver
{
  public aabj(AuthDevActivity paramAuthDevActivity) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.a, true);
      AuthDevActivity.c(this.a);
      if (paramInt != 0) {
        break;
      }
      paramWUserSigInfo = (AccountManager)this.a.app.getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(this.a.app.getCurrentAccountUin(), null);
      }
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.b(this.a).setChecked(true);
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
      paramWUserSigInfo = (ajru)this.a.app.a(34);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.b(this.a, true);
      anoc.a().a(this.a.app, this.a, this.a.app.getCurrentAccountUin(), true);
      AuthDevActivity.c(this.a, true);
      bbmy.a(this.a.getApplicationContext(), 2, this.a.getString(2131626508), 0).b(this.a.getTitleBarHeight());
      AuthDevActivity.d(this.a);
      paramWUserSigInfo = this.a.app.getHandler(LoginInfoActivity.class);
    } while (paramWUserSigInfo == null);
    paramWUserSigInfo.obtainMessage(20140331, 1, 0).sendToTarget();
    return;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      bbmy.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    bbmy.a(this.a.getApplicationContext(), 1, this.a.getString(2131626559), 0).b(this.a.getTitleBarHeight());
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevActivity.a(this.a, true);
    AuthDevActivity.c(this.a);
    if (paramInt == 0)
    {
      paramWUserSigInfo = (WtloginManager)this.a.app.getManager(1);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.RefreshMemorySig();
      }
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.b(this.a).setChecked(false);
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
      AuthDevActivity.a(this.a).setVisibility(8);
      AuthDevActivity.b(this.a).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.success");
      }
      AuthDevActivity.b(this.a, false);
      AuthDevActivity.a(this.a).setVisibility(8);
      anoc.a().a(this.a.app, this.a, this.a.app.getCurrentAccountUin(), false);
      bbmy.a(this.a.getApplicationContext(), 2, this.a.getString(2131626523), 0).b(this.a.getTitleBarHeight());
      paramWUserSigInfo = this.a.app.getHandler(LoginInfoActivity.class);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 0, 0).sendToTarget();
      }
      AuthDevActivity.a(this.a, null);
      AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      bbmy.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    bbmy.a(this.a.getApplicationContext(), 1, this.a.getString(2131626522), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aabj
 * JD-Core Version:    0.7.0.1
 */