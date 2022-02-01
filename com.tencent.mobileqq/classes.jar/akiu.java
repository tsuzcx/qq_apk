import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akiu
  implements View.OnClickListener
{
  akiu(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    akho.a(this.a).app.getPreferences();
    bfng.a().a();
    if (bfng.a().a() == 4)
    {
      bfng.a().a(akho.a(this.a));
      bcef.b(akho.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bfnf.b(), bfng.b(), bfng.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UpgradeDetailActivity.a(akho.a(this.a), bfng.a().a(), true, true, true);
      bcef.b(akho.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bfnf.b(), bfng.b(), bfng.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akiu
 * JD-Core Version:    0.7.0.1
 */