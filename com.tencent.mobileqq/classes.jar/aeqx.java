import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.util.InputMethodUtil;

public class aeqx
  implements AbsListView.OnScrollListener
{
  public aeqx(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(ChooseInterestTagActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqx
 * JD-Core Version:    0.7.0.1
 */