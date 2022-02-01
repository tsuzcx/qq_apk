import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.AddAccountActivity.4.1;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class acot
  extends AccountObserver
{
  public acot(AddAccountActivity paramAddAccountActivity) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_AddAccountActivity", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(1);
      if ((paramBoolean) && (paramInt == 0))
      {
        paramArrayOfByte = new Intent(this.a, RegisterByNicknameAndPwdActivity.class);
        paramArrayOfByte.putExtra("key_register_binduin", this.a.app.getCurrentAccountUin());
        paramArrayOfByte.putExtra("key_register_from_quick_register", true);
        paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
        paramArrayOfByte.putExtra("not_need_verify_sms", true);
        this.a.startActivity(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramArrayOfByte = new Intent(this.a, RegisterPhoneNumActivity.class);
      paramArrayOfByte.putExtra("key_register_from", 1);
      this.a.startActivity(paramArrayOfByte);
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2)
  {
    QLog.d("AddAccountActivity", 1, "onLoginFailed ret=" + paramInt1);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      this.a.runOnUiThread(new AddAccountActivity.4.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt1);
      }
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        QQToast.a(this.a, 2131694062, 0).a();
        return;
      }
    }
    catch (Exception paramArrayOfByte2)
    {
      for (;;)
      {
        paramArrayOfByte2.printStackTrace();
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        paramArrayOfByte2 = new Intent(this.a, NotificationActivity.class);
        paramArrayOfByte2.putExtra("type", 8);
        if (paramInt1 == 40)
        {
          paramArrayOfByte2.putExtra("msg", paramString2);
          paramArrayOfByte2.putExtra("errorver", paramInt2);
        }
        for (;;)
        {
          paramArrayOfByte2.putExtra("loginalias", paramString1);
          paramArrayOfByte2.putExtra("loginret", paramInt1);
          paramArrayOfByte2.putExtra("errorUrl", paramString3);
          paramArrayOfByte2.putExtra("expiredSig", paramArrayOfByte1);
          paramArrayOfByte2.putExtra("keyFromAddAccount", true);
          this.a.startActivity(paramArrayOfByte2);
          return;
          paramArrayOfByte2.putExtra("msg", paramString2 + " " + paramString3);
        }
      }
      if (paramInt1 == 2008)
      {
        bfur.a(this.a, 230, amtj.a(2131698970), amtj.a(2131698971), "OK", null, new acou(this), null).show();
        QQToast.a(this.a, 2131692788, 0).a();
        return;
      }
      bfur.a(this.a, 230, amtj.a(2131698974), paramString2, new acov(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    QLog.d("AddAccountActivity", 1, "onLoginSuccess");
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("AddAccountActivity", 1, "onLoginTimeout");
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      QQToast.a(this.a, 2131694062, 0).a();
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acot
 * JD-Core Version:    0.7.0.1
 */