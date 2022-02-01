import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akif
  implements View.OnClickListener
{
  akif(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (bfng.a().a() == 4)
    {
      bcef.b(akho.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bfnf.b(), bfng.b(), bfng.a(), "1");
      bfng.a().a(akho.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(akho.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bfnf.b(), bfng.b(), bfng.a(), "1");
      UpgradeDetailActivity.a(akho.a(this.a), bfng.a().a(), true, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akif
 * JD-Core Version:    0.7.0.1
 */