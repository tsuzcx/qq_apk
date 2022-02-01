import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajdk
  implements View.OnClickListener
{
  public ajdk(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, ajcv paramajcv) {}
  
  public void onClick(View paramView)
  {
    TroopRecommendFriendFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopTroopRecommendFriendFragment, TroopRecommendFriendFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopTroopRecommendFriendFragment), this.jdField_a_of_type_Ajcv.a, TroopRecommendFriendFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopTroopRecommendFriendFragment));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdk
 * JD-Core Version:    0.7.0.1
 */