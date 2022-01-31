import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class adpf
  extends CardObserver
{
  public adpf(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void b(boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (QLog.isColorLevel())
    {
      QLog.d("LoginWelcomeManager", 2, String.format("mCardObserver.onUpdateAvatar isSuccess=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      if (TextUtils.equals(LoginWelcomeManager.a(this.a).getCurrentAccountUin(), paramString)) {
        if (LoginWelcomeManager.a(this.a) != null)
        {
          paramString = LoginWelcomeManager.a(this.a).getBundle("request");
          if (paramString != null) {
            if (!paramBoolean) {
              break label136;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramString.putInt("result", i);
      paramString.putString("path", LoginWelcomeManager.a(this.a));
      LoginWelcomeManager.a(this.a, null);
      this.a.b();
      LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
      return;
      label136:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adpf
 * JD-Core Version:    0.7.0.1
 */