import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.AutoLoginHelper.4.1;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

public class aalv
  extends AccountObserver
{
  aalv(aals paramaals) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt1), aals.a(this.a), paramString2, paramString1 }));
    }
    this.a.c = false;
    aals.a(this.a);
    if (aals.a(this.a) != null)
    {
      paramString1 = new Intent(aals.a(this.a), LoginActivity.class);
      paramString1.putExtra("uin", aals.a(this.a));
      paramString1.putExtra("tab_index", MainFragment.b);
      paramString1.addFlags(131072);
      aals.a(this.a).startActivity(paramString1);
      aals.a(this.a).finish();
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
    aals.a(this.a);
    aals.a(this.a).a.post(new AutoLoginHelper.4.1(this));
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
 * Qualified Name:     aalv
 * JD-Core Version:    0.7.0.1
 */