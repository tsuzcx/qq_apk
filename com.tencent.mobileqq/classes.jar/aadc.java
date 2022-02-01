import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.richframework.part.list.base.PublicListInnerFragment;

public class aadc
  extends RecyclerView.OnScrollListener
{
  public aadc(PublicListInnerFragment paramPublicListInnerFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((this.a.a != null) && (this.a.a.getDropFrameMonitorTag() != null))
    {
      if (paramInt == 0) {
        adlb.a().a(this.a.a.getDropFrameMonitorTag(), false);
      }
    }
    else {
      return;
    }
    adlb.a().a(this.a.a.getDropFrameMonitorTag());
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadc
 * JD-Core Version:    0.7.0.1
 */