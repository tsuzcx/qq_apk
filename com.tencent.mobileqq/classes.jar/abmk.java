import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class abmk
  extends WtloginObserver
{
  public abmk(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void OnCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginPhoneNumActivity", 2, "OnCheckSMSVerifyLoginAccount appid=" + paramLong1 + " subAppid=" + paramLong2 + " countryCode=" + paramString1 + " mobile=" + bbfj.a(paramString2));
      QLog.d("LoginPhoneNumActivity", 2, "OnCheckSMSVerifyLoginAccount msg=" + paramString3 + " msgCnt=" + paramInt1 + " timeLimit=" + paramInt2 + " ret=" + paramInt3);
      if (paramErrMsg != null) {
        QLog.d("LoginPhoneNumActivity", 2, "OnCheckSMSVerifyLoginAccount errMsg=" + paramErrMsg.getMessage());
      }
    }
    this.a.c();
    if (this.a.isFinishing()) {
      return;
    }
    if (paramInt3 == 0)
    {
      this.a.a();
      return;
    }
    paramString1 = null;
    if (paramErrMsg != null) {
      paramString1 = paramErrMsg.getMessage();
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.a.a(null, paramString1);
      return;
    }
    this.a.a(2131718741, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abmk
 * JD-Core Version:    0.7.0.1
 */