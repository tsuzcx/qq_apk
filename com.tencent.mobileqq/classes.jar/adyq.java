import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adyq
  implements View.OnClickListener
{
  public adyq(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.isFinishing()) {
      ForwardRecentActivity.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adyq
 * JD-Core Version:    0.7.0.1
 */