import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

public class addr
  extends WtloginObserver
{
  public addr(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    this.a.c();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  login success ret =  " + paramInt2);
      }
      paramString = this.a.app.getHandler(LoginPhoneNumActivity.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(2015);
      }
      this.a.finish();
    }
    for (;;)
    {
      return;
      if (paramInt2 == -20160326)
      {
        this.a.finish();
        return;
      }
      if (paramInt2 == 2008)
      {
        this.a.a(2131693231, 0);
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
        this.a.a(2131719225, 1);
      }
      while (paramInt2 == 155)
      {
        this.a.finish();
        return;
        this.a.a(localObject2, 0);
      }
    }
  }
  
  public void OnGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetSubaccountStViaSMSVerifyLogin  userAccount = " + paramString2 + " mainAccount=" + paramString1 + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetSubaccountStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("logintime", 2, "login end.......");
    }
    if (paramInt2 == 0) {
      if ((paramString1 != null) && (paramString2 != null) && (paramString1.equals(paramString2)))
      {
        azyk.d(this.a.app);
        LoginVerifyCodeActivity.b(this.a);
        LoginVerifyCodeActivity.a(this.a, 2131720413, 0);
        this.a.finish();
      }
    }
    for (;;)
    {
      return;
      if (this.a.app != null)
      {
        paramString1 = new HashMap();
        paramString1.put("param_FailCode", "12001");
        paramString1.put("fail_step", "loginsucc");
        paramString1.put("fail_location", "subLogin");
        azmz.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, paramString1, "");
        bdiv.a(this.a.app.getApplication().getApplicationContext(), paramString2, true);
        this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, this.a.a);
        paramString1 = (azyu)this.a.app.getManager(61);
        if (paramString1 == null) {
          break;
        }
        paramString1.a(paramString2, 0, "");
        return;
        this.a.c();
        if (paramInt2 == -20160326)
        {
          this.a.finish();
          return;
        }
        if (paramInt2 == 2008)
        {
          this.a.a(2131693231, 0);
          this.a.finish();
          return;
        }
        Object localObject1 = null;
        Object localObject2 = null;
        paramString1 = localObject2;
        if (paramErrMsg != null)
        {
          String str = paramErrMsg.getMessage();
          paramString1 = localObject2;
          localObject1 = str;
          if (paramErrMsg.getType() == 1)
          {
            paramString1 = paramErrMsg.getOtherinfo();
            localObject1 = str;
          }
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramErrMsg = new Intent(this.a, NotificationActivity.class);
          paramErrMsg.putExtra("type", 8);
          if (paramInt2 == 40) {
            paramErrMsg.putExtra("msg", localObject1);
          }
          for (;;)
          {
            paramErrMsg.putExtra("loginalias", paramString2);
            paramErrMsg.putExtra("loginret", paramInt2);
            this.a.startActivity(paramErrMsg);
            return;
            paramErrMsg.putExtra("msg", localObject1 + " " + paramString1);
          }
        }
        if (TextUtils.isEmpty(localObject1)) {
          this.a.a(2131719225, 1);
        }
        while (paramInt2 == 155)
        {
          this.a.finish();
          return;
          this.a.a(localObject1, 0);
        }
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
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      this.a.c();
      if (paramInt3 == 0) {
        break;
      }
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1)) {
        this.a.a(2131719225, 1);
      }
      while (paramInt3 == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString1, 0);
      }
    }
    LoginVerifyCodeActivity.a(this.a, 60);
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
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      if (paramInt == 0) {
        break;
      }
      this.a.c();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1)) {
        this.a.a(2131719225, 1);
      }
      while (paramInt == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString1, 0);
      }
    }
    LoginVerifyCodeActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addr
 * JD-Core Version:    0.7.0.1
 */