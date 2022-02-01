import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;

public class ajff
  extends RecyclerView.OnScrollListener
{
  public ajff(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.b = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopNotifyAndRecommendView.a(this.a).getItemCount())) {
        TroopNotifyAndRecommendView.g(this.a);
      }
    }
    if (this.a.a != null)
    {
      if (paramInt == 0) {
        break label94;
      }
      this.a.a.a();
      this.a.a.c();
    }
    label94:
    while (!this.a.a.a()) {
      return;
    }
    this.a.a.b();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajff
 * JD-Core Version:    0.7.0.1
 */