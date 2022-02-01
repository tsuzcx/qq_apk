import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeok
  implements View.OnClickListener
{
  public aeok(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D97", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeok
 * JD-Core Version:    0.7.0.1
 */