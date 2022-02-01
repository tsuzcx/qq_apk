import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class allc
  implements View.OnClickListener
{
  allc(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    aljw.a(this.a).app.getPreferences();
    bhdu.a().a();
    if (bhdu.a().a() == 4)
    {
      bhdu.a().a(aljw.a(this.a));
      bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bhdt.b(), bhdu.b(), bhdu.a(), "1");
    }
    for (;;)
    {
      this.a.a(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UpgradeDetailActivity.a(aljw.a(this.a), bhdu.a().a(), true, true, true);
      bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bhdt.b(), bhdu.b(), bhdu.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allc
 * JD-Core Version:    0.7.0.1
 */