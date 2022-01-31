import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

class afbn
  implements View.OnClickListener
{
  afbn(afbk paramafbk) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    azlj.a(afbk.a(this.a), paramView, 17, 10029);
    azzx.a("Grp_contacts_news", "notice", "recom_clk", 1, 0, new String[] { paramView.uin, paramView.recomAlgol });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afbn
 * JD-Core Version:    0.7.0.1
 */