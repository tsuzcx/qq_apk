import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeoc
  implements View.OnClickListener
{
  public aeoc(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.isFinishing()) {
      ForwardFriendListActivity.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoc
 * JD-Core Version:    0.7.0.1
 */