import android.os.Handler;
import android.widget.EditText;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ailu
  extends awhw
{
  public ailu(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "onVerifyBindSms [" + paramBoolean + ", " + paramInt + "]");
    }
    BindVerifyActivity.a(this.a, false);
    BindVerifyActivity.a(this.a).removeMessages(4);
    this.a.b();
    if (!paramBoolean)
    {
      this.a.a("dc00898", "0X8009F19", 0);
      this.a.a(1, this.a.getString(2131719233));
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.b(this.a));
      BindVerifyActivity.b(this.a, null);
      return;
      if ((paramInt == 0) || (paramInt == 106))
      {
        this.a.a();
      }
      else if (paramInt == 213)
      {
        this.a.a("dc00898", "0X8009F19", 0);
        this.a.a(1, alud.a(2131701528));
        BindVerifyActivity.a(this.a).setEnabled(true);
      }
      else
      {
        this.a.a("dc00898", "0X8009F19", 0);
        String str = alud.a(2131701523);
        if (paramInt == 107) {
          str = alud.a(2131701525);
        }
        this.a.a(alud.a(2131701529), str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailu
 * JD-Core Version:    0.7.0.1
 */