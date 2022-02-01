import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akyp
  implements View.OnClickListener
{
  akyp(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bglp.a(akyh.a(this.a), 0, null, anni.a(2131699723), 2131690582, 2131694081, new akyq(this), new akyr(this)).show();
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
 * Qualified Name:     akyp
 * JD-Core Version:    0.7.0.1
 */