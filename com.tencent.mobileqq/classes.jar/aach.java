import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class aach
  extends RecyclerView.OnScrollListener
{
  aach(aacg paramaacg) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((aacg.a(this.a)) && (!paramRecyclerView.isComputingLayout()) && (paramInt == 0))
    {
      aacg.a(this.a, false);
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aach
 * JD-Core Version:    0.7.0.1
 */