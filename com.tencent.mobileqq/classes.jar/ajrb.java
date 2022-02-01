import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajrb
  implements View.OnClickListener
{
  public ajrb(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    TroopSuspiciousFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrb
 * JD-Core Version:    0.7.0.1
 */