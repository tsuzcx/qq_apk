import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afhd
  implements View.OnClickListener
{
  public afhd(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mSwiftTitleUI != null)
    {
      this.a.mSwiftTitleUI.jdField_a_of_type_Bhqo.d = false;
      this.a.mSwiftTitleUI.jdField_a_of_type_Bhqo.a = Boolean.valueOf(true);
      if (this.a.mUIStyleHandler != null) {
        this.a.mUIStyleHandler.l();
      }
    }
    this.a.onClick(this.a.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhd
 * JD-Core Version:    0.7.0.1
 */