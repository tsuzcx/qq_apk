import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;

public class airn
  implements View.OnClickListener
{
  public airn(TeamWorkShareActionSheetBuilder paramTeamWorkShareActionSheetBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((TeamWorkShareActionSheetBuilder.a(this.a) instanceof CustomWebView))
    {
      ((CustomWebView)TeamWorkShareActionSheetBuilder.a(this.a)).c("openCooperationMobile()");
      this.a.b();
      ReportController.b(TeamWorkShareActionSheetBuilder.a(this.a).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airn
 * JD-Core Version:    0.7.0.1
 */