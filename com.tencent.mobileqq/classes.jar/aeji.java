import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;

public class aeji
  implements View.OnClickListener
{
  public aeji(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReminderListFragment.a(this.a) != null) {
      ReminderListFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeji
 * JD-Core Version:    0.7.0.1
 */