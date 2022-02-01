import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afah
  implements View.OnClickListener
{
  public afah(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mSwiftTitleUI != null)
    {
      this.a.mSwiftTitleUI.mUIStyle.isScreenLandscape = false;
      this.a.mSwiftTitleUI.mUIStyle.mIsPortraitOnly = Boolean.valueOf(true);
      if (this.a.mUIStyleHandler != null) {
        this.a.mUIStyleHandler.updateScreenOrientation();
      }
    }
    this.a.onClick(this.a.mSwiftTitleUI.rightViewImg);
    this.a.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afah
 * JD-Core Version:    0.7.0.1
 */