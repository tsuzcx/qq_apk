import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aleo
  implements View.OnClickListener
{
  aleo(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    if (aldh.a(this.a) != null) {}
    for (QQAppInterface localQQAppInterface = aldh.a(this.a).app; localQQAppInterface == null; localQQAppInterface = null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoBar", 2, "app is null");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int j = localQQAppInterface.getAVNotifyCenter().e();
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
      adlp.a(localQQAppInterface, j, aldh.a(this.a));
    }
    for (;;)
    {
      bdla.a(aldh.a(this.a).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 1, 0, "", "", "", "");
      break;
      i = 0;
      break label90;
      label148:
      adlp.b(localQQAppInterface, j, aldh.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleo
 * JD-Core Version:    0.7.0.1
 */