import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;

public class aila
  implements DialogInterface.OnClickListener
{
  public aila(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.k();
    this.a.q();
    if (TroopNotifyAndRecommendView.b(this.a) != null) {
      TroopNotifyAndRecommendView.b(this.a).setVisibility(8);
    }
    bcef.b(this.a.a, "dc00899", "Grp_contacts_news", "", "notice", "clear_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aila
 * JD-Core Version:    0.7.0.1
 */