import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;

public class aepc
  extends RecyclerView.OnScrollListener
{
  public boolean a;
  
  public aepc(ZhituPanelView paramZhituPanelView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      if ((localGridLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == localGridLayoutManager.getItemCount()) && (this.jdField_a_of_type_Boolean)) {
        ((aepd)paramRecyclerView.getAdapter()).a();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepc
 * JD-Core Version:    0.7.0.1
 */