import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aksm
  implements View.OnClickListener
{
  aksm(aksk paramaksk) {}
  
  public void onClick(View paramView)
  {
    try
    {
      axqy.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (akse.a != null) {
        aksk.a(this.a).startActivity(akse.a);
      }
      for (;;)
      {
        this.a.dismiss();
        return;
        if (aksk.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aksk.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        akse.a(aksk.a(this.a));
        aksk.a(this.a).startActivity(akse.a);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(aksk.a(), 2, "Start Activity Failed");
          aksk.a(this.a).startActivity(bbfa.c(aksk.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(aksk.a(), 2, "mAppInterface=null, use default intent");
          }
          aksk.a(this.a).startActivity(bbfa.a(aksk.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksm
 * JD-Core Version:    0.7.0.1
 */