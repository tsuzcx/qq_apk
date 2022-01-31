import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class abvr
  implements View.OnClickListener
{
  public abvr(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    if ((AboutActivity.a(this.a) != null) && (AboutActivity.a(this.a).a != null))
    {
      azmj.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", amlp.a(), "");
      UpgradeDetailActivity.a(this.a, amlp.a().a(), false, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvr
 * JD-Core Version:    0.7.0.1
 */