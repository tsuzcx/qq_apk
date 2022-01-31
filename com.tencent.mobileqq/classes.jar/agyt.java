import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class agyt
  implements View.OnClickListener
{
  agyt(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    agxq.a(this.a).app.getPreferences();
    akgo.a().a();
    if (akgo.a().a() == 4)
    {
      akgo.a().a(agxq.a(this.a));
      awqx.b(agxq.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, akgn.b(), akgo.b(), akgo.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      return;
      UpgradeDetailActivity.a(agxq.a(this.a), akgo.a().a(), true, true, true);
      awqx.b(agxq.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, akgn.b(), akgo.b(), akgo.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyt
 * JD-Core Version:    0.7.0.1
 */