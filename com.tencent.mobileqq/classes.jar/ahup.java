import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahup
  implements View.OnClickListener
{
  public ahup(BlessActivity paramBlessActivity) {}
  
  public void onClick(View paramView)
  {
    bcef.b(this.a.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
    BlessActivity.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahup
 * JD-Core Version:    0.7.0.1
 */