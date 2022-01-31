import android.text.TextUtils;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aaxw
  extends WtloginObserver
{
  public aaxw(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (!this.a.isResume())
    {
      this.a.b();
      return;
    }
    if (((this.a.jdField_a_of_type_Bcqf == null) || (!this.a.jdField_a_of_type_Bcqf.isShowing())) && (paramInt == 0) && (paramDevlockInfo != null))
    {
      this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
      aoem.a().a(this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
      return;
    }
    this.a.b();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
      aoem.a().a(this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
      this.a.a(this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    paramDevlockInfo = this.a.getString(2131692133);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    bcql.a(this.a.getApplicationContext(), paramWUserSigInfo, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxw
 * JD-Core Version:    0.7.0.1
 */