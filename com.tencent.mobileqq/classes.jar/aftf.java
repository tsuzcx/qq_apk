import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aftf
  implements View.OnClickListener
{
  public aftf(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    ReminderListFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftf
 * JD-Core Version:    0.7.0.1
 */