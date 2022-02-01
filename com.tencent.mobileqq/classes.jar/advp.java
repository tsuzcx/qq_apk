import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class advp
  extends WtloginObserver
{
  public advp(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, WeakReference paramWeakReference) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    super.onCheckDevLockStatus(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
    paramWUserSigInfo = (PhoneUnityBindInfoActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramWUserSigInfo == null)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, activity destroyed");
      return;
    }
    PhoneUnityBindInfoActivity.a(paramWUserSigInfo, paramDevlockInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advp
 * JD-Core Version:    0.7.0.1
 */