import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alkn
  implements View.OnClickListener
{
  alkn(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    this.a.a(-1, null);
    if (bhdu.a().a() == 4)
    {
      bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bhdt.b(), bhdu.b(), bhdu.a(), "1");
      bhdu.a().a(aljw.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bhdt.b(), bhdu.b(), bhdu.a(), "1");
      UpgradeDetailActivity.a(aljw.a(this.a), bhdu.a().a(), true, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkn
 * JD-Core Version:    0.7.0.1
 */