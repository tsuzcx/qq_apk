import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class aaqi
  extends RecyclerView.OnScrollListener
{
  aaqi(aaqh paramaaqh) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((aaqh.a(this.a)) && (!paramRecyclerView.isComputingLayout()) && (paramInt == 0))
    {
      aaqh.a(this.a, false);
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqi
 * JD-Core Version:    0.7.0.1
 */