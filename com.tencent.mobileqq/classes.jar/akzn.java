import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akzn
  implements View.OnClickListener
{
  akzn(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    akyh.a(this.a).app.getPreferences();
    bgdt.a().a();
    if (bgdt.a().a() == 4)
    {
      bgdt.a().a(akyh.a(this.a));
      bcst.b(akyh.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bgds.b(), bgdt.b(), bgdt.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UpgradeDetailActivity.a(akyh.a(this.a), bgdt.a().a(), true, true, true);
      bcst.b(akyh.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bgds.b(), bgdt.b(), bgdt.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzn
 * JD-Core Version:    0.7.0.1
 */