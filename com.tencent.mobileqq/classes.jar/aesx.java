import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.mobileqq.nearby.now.location.adapter.LocationListAdapter;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.widget.ItemClickHelper;
import com.tencent.util.LogUtil;
import java.util.List;

public class aesx
  extends ItemClickHelper
{
  public aesx(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void a(int paramInt, View paramView)
  {
    LogUtil.d("SelectLocationFragment", "onItemClick: " + paramInt);
    SelectLocationFragment.a(this.a, paramInt);
    SelectLocationFragment.b(this.a, (LocationInfo)SelectLocationFragment.a(this.a).a().get(paramInt));
    new NowVideoReporter().h("video_public").i("change_poi").d(SmallVideoCameraCaptureFragment.a).a(SelectLocationFragment.a(this.a)).b(this.a.getActivity().app);
    LogUtil.d("SelectLocationFragment", "onItemClick: " + SelectLocationFragment.b(this.a).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesx
 * JD-Core Version:    0.7.0.1
 */