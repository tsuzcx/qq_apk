import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aksn
  implements View.OnClickListener
{
  aksn(aksl paramaksl) {}
  
  public void onClick(View paramView)
  {
    try
    {
      axqw.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (aksf.a != null) {
        aksl.a(this.a).startActivity(aksf.a);
      }
      for (;;)
      {
        this.a.dismiss();
        return;
        if (aksl.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aksl.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        aksf.a(aksl.a(this.a));
        aksl.a(this.a).startActivity(aksf.a);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(aksl.a(), 2, "Start Activity Failed");
          aksl.a(this.a).startActivity(bbem.c(aksl.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(aksl.a(), 2, "mAppInterface=null, use default intent");
          }
          aksl.a(this.a).startActivity(bbem.a(aksl.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksn
 * JD-Core Version:    0.7.0.1
 */