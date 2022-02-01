import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afqf
  implements View.OnClickListener
{
  public afqf(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.b(this.a.getShareUrl());
    paramView.setEnabled(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqf
 * JD-Core Version:    0.7.0.1
 */