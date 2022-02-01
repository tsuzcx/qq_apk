import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aekc
  implements View.OnClickListener
{
  public aekc(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aekc
 * JD-Core Version:    0.7.0.1
 */