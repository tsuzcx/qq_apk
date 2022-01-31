import android.os.Bundle;
import com.tencent.widget.AbsListView;

class afme
  implements bfos
{
  afme(afly paramafly) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    afly.a(this.a, paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    if (afly.b(this.a) >= this.a.getCount() - 2)
    {
      paramAbsListView = new Bundle();
      paramAbsListView.putString("from", "4");
      afly.a(this.a).b(4, afly.a(this.a), paramAbsListView);
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afme
 * JD-Core Version:    0.7.0.1
 */