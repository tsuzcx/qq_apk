import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agdd
  implements View.OnClickListener
{
  public agdd(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    this.a.setResult(0);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdd
 * JD-Core Version:    0.7.0.1
 */