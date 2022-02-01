import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeua
  implements View.OnClickListener
{
  public aeua(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeua
 * JD-Core Version:    0.7.0.1
 */