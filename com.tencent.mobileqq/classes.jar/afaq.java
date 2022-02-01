import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afaq
  implements View.OnClickListener
{
  public afaq(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afaq
 * JD-Core Version:    0.7.0.1
 */