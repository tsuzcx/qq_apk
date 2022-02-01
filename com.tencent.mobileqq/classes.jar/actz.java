import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class actz
  extends WtloginObserver
{
  public actz(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.a, true);
      AuthDevActivity.c(this.a);
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCheckDevLockSms result : ret is ", Integer.valueOf(paramInt) });
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
      paramWUserSigInfo = (anat)this.a.app.getBusinessHandler(34);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.b(this.a, true);
      arhf.a().a(this.a.app, this.a, this.a.app.getCurrentAccountUin(), true);
      AuthDevActivity.c(this.a, true);
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131691843), 0).b(this.a.getTitleBarHeight());
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
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131691885), 0).b(this.a.getTitleBarHeight());
  }
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = true;
    if (this.a.isFinishing())
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "OnCheckDevLockStatus activity is finished");
      return;
    }
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.ProtectIntro:" + paramDevlockInfo.ProtectIntro + "  info.MbGuideType:" + paramDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.MbGuideMsg:" + paramDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      argz.a().a(paramDevlockInfo.TransferInfo);
      AuthDevActivity.a(this.a, paramDevlockInfo);
      AuthDevActivity.a(this.a, AuthDevActivity.a(this.a).Mobile);
      paramWUserSigInfo = this.a;
      if (AuthDevActivity.a(this.a).DevSetup == 1)
      {
        bool1 = true;
        AuthDevActivity.b(paramWUserSigInfo, bool1);
        paramWUserSigInfo = this.a;
        if (AuthDevActivity.a(this.a).AllowSet != 1) {
          break label395;
        }
      }
      label395:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        AuthDevActivity.d(paramWUserSigInfo, bool1);
        AuthDevActivity.f(this.a);
        return;
        bool1 = false;
        break;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    AuthDevActivity.g(this.a);
    paramDevlockInfo = this.a.getString(2131691876);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    QQToast.a(this.a.getApplicationContext(), paramWUserSigInfo, 0).b(this.a.getTitleBarHeight());
  }
  
  public void onCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.a, true);
      AuthDevActivity.c(this.a);
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCloseDevLock response , ret is ", Integer.valueOf(paramInt) });
      if (paramInt != 0) {
        break;
      }
      paramWUserSigInfo = (WtloginManager)this.a.app.getManager(1);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshMemorySig();
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
      arhf.a().a(this.a.app, this.a, this.a.app.getCurrentAccountUin(), false);
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131691854), 0).b(this.a.getTitleBarHeight());
      paramWUserSigInfo = this.a.app.getHandler(LoginInfoActivity.class);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 0, 0).sendToTarget();
      }
      AuthDevActivity.b(this.a, null);
      AuthDevActivity.a(this.a, AuthDevActivity.b(this.a));
    } while (!AuthDevActivity.b(this.a));
    AuthDevActivity.e(this.a);
    return;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131691853), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actz
 * JD-Core Version:    0.7.0.1
 */