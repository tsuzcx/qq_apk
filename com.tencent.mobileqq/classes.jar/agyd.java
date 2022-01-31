import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;

class agyd
  implements View.OnClickListener
{
  agyd(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (akgo.a().a() == 4)
    {
      awqx.b(agxq.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, akgn.b(), akgo.b(), akgo.a(), "1");
      akgo.a().a(agxq.a(this.a));
      return;
    }
    awqx.b(agxq.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, akgn.b(), akgo.b(), akgo.a(), "1");
    UpgradeDetailActivity.a(agxq.a(this.a), akgo.a().a(), true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyd
 * JD-Core Version:    0.7.0.1
 */