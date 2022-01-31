import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

class afnd
  implements View.OnClickListener
{
  afnd(afna paramafna) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    bamn.a(afna.a(this.a), paramView, 17, 10029);
    bbbb.a("Grp_contacts_news", "notice", "recom_clk", 1, 0, new String[] { paramView.uin, paramView.recomAlgol });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afnd
 * JD-Core Version:    0.7.0.1
 */