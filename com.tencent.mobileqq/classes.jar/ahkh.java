import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

class ahkh
  implements View.OnClickListener
{
  ahkh(ahke paramahke) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    bclo.a(ahke.a(this.a), paramView, 17, 10029);
    bdaj.a("Grp_contacts_news", "notice", "recom_clk", 1, 0, new String[] { paramView.uin, paramView.recomAlgol });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkh
 * JD-Core Version:    0.7.0.1
 */