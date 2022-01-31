import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.AutoLoginHelper.4.1;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

public class aacc
  extends AccountObserver
{
  aacc(aabz paramaabz) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt, paramArrayOfByte);
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt), aabz.a(this.a), paramString2, paramString1 }));
    }
    this.a.c = false;
    aabz.a(this.a);
    if (aabz.a(this.a) != null)
    {
      paramString1 = new Intent(aabz.a(this.a), LoginActivity.class);
      paramString1.putExtra("uin", aabz.a(this.a));
      paramString1.putExtra("tab_index", MainFragment.b);
      paramString1.addFlags(131072);
      aabz.a(this.a).startActivity(paramString1);
      aabz.a(this.a).finish();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    super.onLoginSuccess(paramString1, paramString2);
    this.a.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onLoginTimeout ");
    }
    this.a.c = false;
    aabz.a(this.a);
    aabz.a(this.a).a.post(new AutoLoginHelper.4.1(this));
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    this.a.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aacc
 * JD-Core Version:    0.7.0.1
 */