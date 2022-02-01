import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adhs
  implements View.OnClickListener
{
  public adhs(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.overridePendingTransition(2130771997, 2130772001);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhs
 * JD-Core Version:    0.7.0.1
 */