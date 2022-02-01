import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alld
  implements View.OnClickListener
{
  alld(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    if (bhdu.a().a() == 4) {
      bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, bhdt.b(), bhdu.b(), bhdu.a(), "0");
    }
    for (;;)
    {
      this.a.a(15, 0);
      this.a.a(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(aljw.a(this.a).app, "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, bhdt.b(), bhdu.b(), bhdu.a(), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alld
 * JD-Core Version:    0.7.0.1
 */