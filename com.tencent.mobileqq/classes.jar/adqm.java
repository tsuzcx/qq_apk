import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adqm
  implements View.OnClickListener
{
  public adqm(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    if ((AboutActivity.a(this.a) != null) && (AboutActivity.a(this.a).a != null))
    {
      bdll.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", bhdu.a(), "");
      UpgradeDetailActivity.a(this.a, bhdu.a().a(), false, false, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqm
 * JD-Core Version:    0.7.0.1
 */