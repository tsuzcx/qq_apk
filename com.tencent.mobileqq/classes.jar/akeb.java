import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class akeb
  implements View.OnClickListener
{
  akeb(akdz paramakdz) {}
  
  public void onClick(View paramView)
  {
    try
    {
      awqx.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (akdt.a != null) {
        akdz.a(this.a).startActivity(akdt.a);
      }
      for (;;)
      {
        this.a.dismiss();
        return;
        if (akdz.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(akdz.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        akdt.a(akdz.a(this.a));
        akdz.a(this.a).startActivity(akdt.a);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(akdz.a(), 2, "Start Activity Failed");
          akdz.a(this.a).startActivity(badh.c(akdz.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(akdz.a(), 2, "mAppInterface=null, use default intent");
          }
          akdz.a(this.a).startActivity(badh.a(akdz.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akeb
 * JD-Core Version:    0.7.0.1
 */