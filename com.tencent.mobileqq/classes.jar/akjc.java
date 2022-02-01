import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akjc
  implements View.OnClickListener
{
  akjc(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    this.a.a(25, 0);
    this.a.a(-1, null);
    bcef.b(akho.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleClose", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjc
 * JD-Core Version:    0.7.0.1
 */