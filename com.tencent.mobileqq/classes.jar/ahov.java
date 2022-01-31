import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

class ahov
  implements View.OnClickListener
{
  ahov(ahot paramahot) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    bcpx.a(ahot.a(this.a), paramView, 10001);
    bdes.a("Grp_contacts_news", "notice", "recom_clk_add", 0, 0, new String[] { paramView.uin, paramView.recomAlgol });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahov
 * JD-Core Version:    0.7.0.1
 */