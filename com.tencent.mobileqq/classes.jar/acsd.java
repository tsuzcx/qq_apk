import Wallet.AcsMsg;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;

public class acsd
  implements View.OnClickListener
{
  public acsd(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (AcsMsg)paramView.getTag();
    ReminderListFragment.a(this.a, paramView);
    if (ReminderListFragment.a(this.a) != null) {
      ReminderListFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */