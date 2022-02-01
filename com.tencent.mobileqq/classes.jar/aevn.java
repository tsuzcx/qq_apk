import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aevn
  implements View.OnClickListener
{
  public aevn(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    ReminderListFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevn
 * JD-Core Version:    0.7.0.1
 */