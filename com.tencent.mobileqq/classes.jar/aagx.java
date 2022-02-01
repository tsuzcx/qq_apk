import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;

class aagx
  extends RecyclerView.OnScrollListener
{
  aagx(aagu paramaagu) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((this.a.a instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)this.a.a;
      paramRecyclerView.computeVerticalScrollExtent(new RecyclerView.State());
      int[] arrayOfInt = new int[paramRecyclerView.getColumnCountForAccessibility(null, null)];
      paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
      if ((this.a.getLocalPosition(arrayOfInt[0]) <= 0) && (!aagu.b(this.a)))
      {
        aagu.a(this.a, true);
        paramRecyclerView.invalidateSpanAssignments();
      }
      if (arrayOfInt[0] > 2) {
        aagu.a(this.a, false);
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagx
 * JD-Core Version:    0.7.0.1
 */