import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afxc
  extends atog
{
  public afxc(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "onBindMobile [" + paramBoolean + ", " + paramBundle + "]");
    }
    this.a.b();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0)) {
        this.a.b();
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
      BindVerifyActivity.a(this.a, null);
      return;
      if (i == 107)
      {
        this.a.a(paramBundle);
      }
      else if (i == 106)
      {
        this.a.a();
        if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
          awqx.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 2, 0, "", "", "", "");
        }
      }
      else
      {
        this.a.a(1, a(i));
        continue;
        this.a.a(1, this.a.getString(2131652912));
      }
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "onRebindMobile [" + paramBoolean + ", " + paramBundle + "]");
    }
    this.a.b();
    if (paramBoolean) {
      this.a.b();
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
      BindVerifyActivity.a(this.a, null);
      return;
      this.a.a(1, this.a.getString(2131652912));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxc
 * JD-Core Version:    0.7.0.1
 */