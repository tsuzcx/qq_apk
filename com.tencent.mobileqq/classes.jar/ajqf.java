import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;

public class ajqf
  implements DialogInterface.OnClickListener
{
  public ajqf(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.k();
    this.a.q();
    if (TroopNotifyAndRecommendView.b(this.a) != null) {
      TroopNotifyAndRecommendView.b(this.a).setVisibility(8);
    }
    bdll.b(this.a.a, "dc00899", "Grp_contacts_news", "", "notice", "clear_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqf
 * JD-Core Version:    0.7.0.1
 */