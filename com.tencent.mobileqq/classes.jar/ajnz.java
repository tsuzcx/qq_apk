import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;

public class ajnz
  extends RecyclerView.OnScrollListener
{
  public ajnz(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    TroopRecommendFriendFragment.a(this.a, paramInt);
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopRecommendFriendFragment.a(this.a).getItemCount())) {
        TroopRecommendFriendFragment.a(this.a);
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnz
 * JD-Core Version:    0.7.0.1
 */