import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alem
  implements View.OnClickListener
{
  alem(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    aldh.a(this.a).app.getPreferences();
    bgvx.a().a();
    if (bgvx.a().a() == 4)
    {
      bgvx.a().a(aldh.a(this.a));
      bdla.b(aldh.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bgvw.b(), bgvx.b(), bgvx.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UpgradeDetailActivity.a(aldh.a(this.a), bgvx.a().a(), true, true, true);
      bdla.b(aldh.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bgvw.b(), bgvx.b(), bgvx.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alem
 * JD-Core Version:    0.7.0.1
 */