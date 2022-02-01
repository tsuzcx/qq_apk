import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class aipy
  implements AbsListView.OnScrollListener
{
  aipy(aipx paramaipx) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onScrollStateChanged firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if ((paramInt1 >= 1) && (paramInt1 - 1 >= 0) && (paramInt1 - 1 < this.a.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.a.getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.a.a.b(paramAbsListView, 20, 0, 1);
      }
    }
    if ((paramInt1 + paramInt2 < paramInt3) && (paramInt1 + paramInt2 >= 0) && (paramInt1 + paramInt2 < this.a.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.a.getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.a.a.b(paramAbsListView, 20, 0, 1);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipy
 * JD-Core Version:    0.7.0.1
 */