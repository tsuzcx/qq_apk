import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aema
  implements View.OnClickListener
{
  public aema(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aema
 * JD-Core Version:    0.7.0.1
 */