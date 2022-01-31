import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity.4.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

public class adux
  extends AccountObserver
{
  public adux(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt1), RegisterQQNumberActivity.a(this.a), paramString2, paramString1 }));
    }
    RegisterQQNumberActivity.a(this.a);
    paramString1 = new Intent(this.a, LoginActivity.class);
    paramString1.putExtra("uin", RegisterQQNumberActivity.a(this.a));
    paramString1.putExtra("tab_index", MainFragment.b);
    paramString1.addFlags(131072);
    this.a.startActivity(paramString1);
    this.a.finish();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    super.onLoginSuccess(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginTimeout ");
    }
    RegisterQQNumberActivity.a(this.a);
    this.a.a.post(new RegisterQQNumberActivity.4.1(this));
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adux
 * JD-Core Version:    0.7.0.1
 */