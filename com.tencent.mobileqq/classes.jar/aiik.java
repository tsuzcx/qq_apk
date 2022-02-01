import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class aiik
  implements aiiv
{
  public aiik(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof aihv)) {
      return;
    }
    paramView = ((aihv)paramViewHolder).a;
    TroopUtils.openUserProfileCardForTroopRecommend(TroopRecommendFriendFragment.a(this.a), TroopRecommendFriendFragment.a(this.a), paramView.a, TroopRecommendFriendFragment.a(this.a), TroopRecommendFriendFragment.a(this.a));
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiik
 * JD-Core Version:    0.7.0.1
 */