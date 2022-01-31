import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;

public class acry
  implements View.OnClickListener
{
  public acry(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReminderListFragment.a(this.a) != null) {
      ReminderListFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acry
 * JD-Core Version:    0.7.0.1
 */