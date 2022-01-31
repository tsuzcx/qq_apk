import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.location.LocationDataManager;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.util.LogUtil;

public class aefl
  implements View.OnClickListener
{
  public aefl(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void onClick(View paramView)
  {
    LogUtil.d("SelectLocationFragment", "mNetworkErrorView onClick()");
    if (SelectLocationFragment.a(this.a) == null)
    {
      LogUtil.d("SelectLocationFragment", "mNetworkErrorView getLocation()");
      SelectLocationFragment.b(this.a);
    }
    while (SelectLocationFragment.a(this.a) == null) {
      return;
    }
    LogUtil.d("SelectLocationFragment", "mNetworkErrorView search()");
    SelectLocationFragment.a(this.a).a(SelectLocationFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aefl
 * JD-Core Version:    0.7.0.1
 */