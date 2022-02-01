import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajnq
  implements View.OnClickListener
{
  ajnq(ajno paramajno) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    bguq.a(ajno.a(this.a), localRecommendTroopItem, this.a.b(), this.a.c());
    this.a.a(localRecommendTroopItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnq
 * JD-Core Version:    0.7.0.1
 */