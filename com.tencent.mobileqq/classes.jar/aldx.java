import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aldx
  implements View.OnClickListener
{
  aldx(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (bgvx.a().a() == 4)
    {
      bdla.b(aldh.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bgvw.b(), bgvx.b(), bgvx.a(), "1");
      bgvx.a().a(aldh.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(aldh.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bgvw.b(), bgvx.b(), bgvx.a(), "1");
      UpgradeDetailActivity.a(aldh.a(this.a), bgvx.a().a(), true, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldx
 * JD-Core Version:    0.7.0.1
 */