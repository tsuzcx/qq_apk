import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alke
  implements View.OnClickListener
{
  alke(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bhlq.a(aljw.a(this.a), 0, null, anzj.a(2131699830), 2131690580, 2131694098, new alkf(this), new alkg(this)).show();
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
 * Qualified Name:     alke
 * JD-Core Version:    0.7.0.1
 */