import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afwy
  implements View.OnClickListener
{
  public afwy(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.d;
    bghf.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwy
 * JD-Core Version:    0.7.0.1
 */