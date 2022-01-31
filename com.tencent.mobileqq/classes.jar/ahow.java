import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

class ahow
  implements View.OnClickListener
{
  ahow(ahot paramahot) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    bcpx.a(ahot.a(this.a), paramView, 17, 10029);
    bdes.a("Grp_contacts_news", "notice", "recom_clk", 1, 0, new String[] { paramView.uin, paramView.recomAlgol });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahow
 * JD-Core Version:    0.7.0.1
 */