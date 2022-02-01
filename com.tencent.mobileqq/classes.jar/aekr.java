import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aekr
  implements View.OnClickListener
{
  public aekr(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(View paramView)
  {
    DiscussionInfoCardActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekr
 * JD-Core Version:    0.7.0.1
 */