import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afhj
  implements View.OnClickListener
{
  public afhj(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.d;
    bfxp.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhj
 * JD-Core Version:    0.7.0.1
 */