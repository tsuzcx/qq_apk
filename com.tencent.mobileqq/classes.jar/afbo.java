import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbo
  implements View.OnClickListener
{
  public afbo(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    avot.a(this.a, "2", -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbo
 * JD-Core Version:    0.7.0.1
 */