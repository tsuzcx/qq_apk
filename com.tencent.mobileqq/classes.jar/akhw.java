import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akhw
  implements View.OnClickListener
{
  akhw(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bfur.a(akho.a(this.a), 0, null, amtj.a(2131700065), 2131690620, 2131694201, new akhx(this), new akhy(this)).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhw
 * JD-Core Version:    0.7.0.1
 */