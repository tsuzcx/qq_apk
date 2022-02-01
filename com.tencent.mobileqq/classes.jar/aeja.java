import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qphone.base.util.QLog;

public class aeja
  implements View.OnLongClickListener
{
  public aeja(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.a).a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
      }
      return false;
    }
    bgwg localbgwg = (bgwg)this.a.mComponentsProvider.a(8);
    if ((localbgwg != null) && (localbgwg.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeja
 * JD-Core Version:    0.7.0.1
 */