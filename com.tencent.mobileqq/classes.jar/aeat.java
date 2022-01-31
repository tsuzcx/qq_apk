import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qphone.base.util.QLog;

public class aeat
  implements View.OnLongClickListener
{
  public aeat(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
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
    beib localbeib = (beib)this.a.a.a(8);
    if ((localbeib != null) && (localbeib.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeat
 * JD-Core Version:    0.7.0.1
 */