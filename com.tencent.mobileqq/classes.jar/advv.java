import android.os.Bundle;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class advv
  extends aycd
{
  public advv(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.c(this.a);
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        this.a.i();
        this.a.a(false);
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.b);
      this.a.b = null;
      return;
      if (i == 107)
      {
        paramBundle = this.a.a.getString("country_code");
        byte[] arrayOfByte = this.a.a(3);
        if (arrayOfByte != null)
        {
          PhoneUnityBindInfoActivity.a(this.a).b(paramBundle, arrayOfByte, 0, true, false);
          PhoneUnityBindInfoActivity.b(this.a, 2131718142, 1000L, true);
        }
        for (;;)
        {
          bcef.b(this.a.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "2", "", "", "");
          return;
          if (QLog.isColorLevel()) {
            QLog.e("PhoneUnityBindInfoActivity", 2, "sendBindMobileEncrypt contact vaskey is null.");
          }
        }
      }
      if (i == 106)
      {
        this.a.a();
        bcef.b(this.a.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "1", "", "", "");
      }
      else if (i == 227)
      {
        this.a.j();
        this.a.a(false);
      }
      else if (i == 226)
      {
        this.a.k();
        this.a.a(false);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityBindInfoActivity", 2, "bind error " + i);
        }
        PhoneUnityBindInfoActivity.b(this.a, a(i));
        this.a.a(false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityBindInfoActivity", 2, "onBindMobile failed");
        }
        PhoneUnityBindInfoActivity.c(this.a, 2131717686);
        this.a.a(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.d(this.a);
    if (paramBoolean) {
      this.a.i();
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.b);
      this.a.b = null;
      return;
      PhoneUnityBindInfoActivity.d(this.a, 2131717686);
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advv
 * JD-Core Version:    0.7.0.1
 */