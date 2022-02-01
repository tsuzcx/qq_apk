import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akyy
  implements View.OnClickListener
{
  akyy(akyh paramakyh) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (bgdt.a().a() == 4)
    {
      bcst.b(akyh.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bgds.b(), bgdt.b(), bgdt.a(), "1");
      bgdt.a().a(akyh.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(akyh.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bgds.b(), bgdt.b(), bgdt.a(), "1");
      UpgradeDetailActivity.a(akyh.a(this.a), bgdt.a().a(), true, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyy
 * JD-Core Version:    0.7.0.1
 */