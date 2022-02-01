import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adyr
  implements View.OnClickListener
{
  public adyr(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() == 0)) {
      this.a.a.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adyr
 * JD-Core Version:    0.7.0.1
 */