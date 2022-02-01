import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afem
  implements View.OnClickListener
{
  public afem(SigCommentListActivity paramSigCommentListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afem
 * JD-Core Version:    0.7.0.1
 */