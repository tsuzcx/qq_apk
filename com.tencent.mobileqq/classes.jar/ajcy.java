import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajcy
  implements View.OnClickListener
{
  ajcy(ajcw paramajcw) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    TroopUtils.openRecommendTroop(ajcw.a(this.a), localRecommendTroopItem, this.a.b(), this.a.c());
    this.a.a(localRecommendTroopItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcy
 * JD-Core Version:    0.7.0.1
 */