import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ailn
  extends awhw
{
  public ailn(BindNumberActivity paramBindNumberActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.f = false;
    this.a.a();
    this.a.b();
    int i;
    if (paramBoolean)
    {
      String str = bdgc.a();
      if (!TextUtils.isEmpty(str)) {
        azqs.b(this.a.app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      i = paramBundle.getInt("k_result");
      if (paramBundle.getBoolean("k_buto_bind", false)) {
        this.a.c();
      }
    }
    for (;;)
    {
      bdgc.a();
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
      return;
      if ((i == 104) || (i == 0))
      {
        this.a.b();
      }
      else
      {
        if (i == 107)
        {
          this.a.a(paramBundle);
          return;
        }
        if (i == 106)
        {
          this.a.a(null, 2);
        }
        else if (i == 227)
        {
          this.a.d();
        }
        else if (i == 226)
        {
          this.a.e();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, "bind error " + i);
          }
          this.a.a(a(i));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, "onBindMobile failed");
          }
          this.a.b(2131719233);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b();
    if (paramBoolean) {
      this.a.b();
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
      return;
      this.a.b(2131719233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailn
 * JD-Core Version:    0.7.0.1
 */