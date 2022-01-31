import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;

public class ahlc
  implements View.OnClickListener
{
  public ahlc(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    bdaj.a("Grp_contacts_news", "notice", "unnormal_clk", 0, 0, new String[0]);
    TroopSuspiciousFragment.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlc
 * JD-Core Version:    0.7.0.1
 */