import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class allk
  implements View.OnClickListener
{
  allk(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    this.a.a(23, 0);
    this.a.a(-1, null);
    bdll.b(aljw.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleClose", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allk
 * JD-Core Version:    0.7.0.1
 */