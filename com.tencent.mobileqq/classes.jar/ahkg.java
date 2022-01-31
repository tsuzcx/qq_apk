import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

class ahkg
  implements View.OnClickListener
{
  ahkg(ahke paramahke) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    bclo.a(ahke.a(this.a), paramView, 10001);
    bdaj.a("Grp_contacts_news", "notice", "recom_clk_add", 0, 0, new String[] { paramView.uin, paramView.recomAlgol });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkg
 * JD-Core Version:    0.7.0.1
 */