import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class allf
  implements AbsListView.OnScrollListener
{
  allf(allb paramallb) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    allb.a(this.a, paramInt);
    if (paramInt == 0)
    {
      allb.a(this.a, null, null);
      allb.a(this.a).resume();
      return;
    }
    allb.a(this.a).pause();
    allb.a(this.a).cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allf
 * JD-Core Version:    0.7.0.1
 */