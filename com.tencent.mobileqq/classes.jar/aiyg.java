import android.os.Bundle;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class aiyg
  implements AbsListView.OnScrollListener
{
  aiyg(aiya paramaiya) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    aiya.a(this.a, paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    if (aiya.b(this.a) >= this.a.getCount() - 2)
    {
      paramAbsListView = new Bundle();
      paramAbsListView.putString("from", "4");
      aiya.a(this.a).b(4, aiya.a(this.a), paramAbsListView);
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyg
 * JD-Core Version:    0.7.0.1
 */