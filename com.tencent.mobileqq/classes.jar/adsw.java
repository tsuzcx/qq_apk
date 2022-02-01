import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsw
  implements View.OnClickListener
{
  public adsw(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adsw
 * JD-Core Version:    0.7.0.1
 */