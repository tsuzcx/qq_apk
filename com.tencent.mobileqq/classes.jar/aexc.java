import android.view.View;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public class aexc
  implements AbsListView.OnScrollListener
{
  public aexc(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramInt = i;
      if (NearbyMomentFragment.a(this.a).getLastVisiblePosition() == NearbyMomentFragment.a(this.a).getCount() - 1)
      {
        paramAbsListView = NearbyMomentFragment.a(this.a).getChildAt(NearbyMomentFragment.a(this.a).getLastVisiblePosition() - NearbyMomentFragment.a(this.a).getFirstVisiblePosition());
        paramInt = i;
        if (NearbyMomentFragment.a(this.a).getHeight() >= paramAbsListView.getBottom()) {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        NearbyMomentFragment.a(this.a);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aexc
 * JD-Core Version:    0.7.0.1
 */