import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afkf
  implements View.OnClickListener
{
  public afkf(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    TroopInfoActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkf
 * JD-Core Version:    0.7.0.1
 */