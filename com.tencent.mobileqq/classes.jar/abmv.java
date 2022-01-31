import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class abmv
  extends WtloginObserver
{
  public abmv(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0)
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  login success ret =  " + paramInt2);
      if ((LoginVerifyCodeActivity2.c(this.a) == 2) || (LoginVerifyCodeActivity2.c(this.a) == 3))
      {
        this.a.c();
        paramArrayOfByte = new Intent();
        paramArrayOfByte.putExtra("last_account", paramString);
        this.a.setResult(-1, paramArrayOfByte);
        this.a.finish();
      }
    }
    for (;;)
    {
      return;
      LoginVerifyCodeActivity2.a(this.a).ssoGetTicketNoPasswd(paramString, 4096, this.a.a);
      return;
      this.a.c();
      if (paramInt2 == -20160326)
      {
        this.a.finish();
        return;
      }
      if (paramInt2 == 2008)
      {
        this.a.a(2131693129, 0);
        this.a.finish();
        return;
      }
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = localObject3;
      if (paramErrMsg != null)
      {
        String str = paramErrMsg.getMessage();
        localObject1 = localObject3;
        localObject2 = str;
        if (paramErrMsg.getType() == 1)
        {
          localObject1 = paramErrMsg.getOtherinfo();
          localObject2 = str;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramErrMsg = new Intent(this.a, NotificationActivity.class);
        paramErrMsg.putExtra("type", 8);
        if (paramInt2 == 40) {
          paramErrMsg.putExtra("msg", localObject2);
        }
        for (;;)
        {
          paramErrMsg.putExtra("loginalias", paramString);
          paramErrMsg.putExtra("loginret", paramInt2);
          paramErrMsg.putExtra("expiredSig", paramArrayOfByte);
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.i("LoginVerifyCodeActivity", 4, "OnGetStViaSMSVerifyLogin, goto Notification");
          }
          paramErrMsg.putExtra("lh_is_from_login_verify_code", true);
          this.a.startActivityForResult(paramErrMsg, 1);
          return;
          paramErrMsg.putExtra("msg", localObject2 + " " + (String)localObject1);
        }
        this.a.startActivity(paramErrMsg);
        return;
      }
      if (TextUtils.isEmpty(localObject2)) {
        this.a.a();
      }
      while (paramInt2 == 155)
      {
        this.a.finish();
        return;
        this.a.a(localObject2, 0);
      }
    }
  }
  
  public void OnRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.mobile=" + paramString1 + " msg=" + paramString2 + " timeLimit=" + paramInt2);
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.ret=" + paramInt3);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.errMsg=" + paramErrMsg);
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (paramInt3 != 0)
    {
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.a.a();
        return;
      }
      this.a.a(paramString1, 0);
      return;
    }
    LoginVerifyCodeActivity2.a(this.a, 60);
  }
  
  public void OnVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount mobile=" + paramString1 + " msgCode=" + paramString2 + " ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount errMsg=" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (paramInt != 0)
    {
      this.a.c();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.a.a();
        return;
      }
      this.a.a(paramString1, 0);
      return;
    }
    LoginVerifyCodeActivity2.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abmv
 * JD-Core Version:    0.7.0.1
 */