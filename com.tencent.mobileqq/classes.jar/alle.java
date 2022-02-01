import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alle
  implements View.OnClickListener
{
  alle(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    if (aljw.a(this.a) != null) {}
    for (QQAppInterface localQQAppInterface = aljw.a(this.a).app; localQQAppInterface == null; localQQAppInterface = null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoBar", 2, "app is null");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int j = localQQAppInterface.a().e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
    }
    int i;
    if ((j == 1) || (j == 2))
    {
      i = 1;
      label90:
      if (i == 0) {
        break label148;
      }
      adzv.a(localQQAppInterface, j, aljw.a(this.a));
    }
    for (;;)
    {
      bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 1, 0, "", "", "", "");
      break;
      i = 0;
      break label90;
      label148:
      adzv.b(localQQAppInterface, j, aljw.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alle
 * JD-Core Version:    0.7.0.1
 */