import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class abbv
  implements View.OnClickListener
{
  public abbv(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.isFinishing()) {
      ForwardFriendListActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abbv
 * JD-Core Version:    0.7.0.1
 */