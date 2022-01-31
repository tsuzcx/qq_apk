import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qphone.base.util.QLog;

public class abum
  implements View.OnLongClickListener
{
  public abum(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
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
    bbbd localbbbd = (bbbd)this.a.a.a(8);
    if ((localbbbd != null) && (localbbbd.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abum
 * JD-Core Version:    0.7.0.1
 */