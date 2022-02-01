import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajdy
  implements View.OnClickListener
{
  ajdy(ajdv paramajdv) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    bfup.a(ajdv.a(this.a), localRecommendTroopItem, 17, 10029);
    bgjt.a("Grp_contacts_news", "notice", "recom_clk", 1, 0, new String[] { localRecommendTroopItem.uin, localRecommendTroopItem.recomAlgol });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdy
 * JD-Core Version:    0.7.0.1
 */