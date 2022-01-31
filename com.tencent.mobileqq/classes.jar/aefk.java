import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;

public class aefk
  implements View.OnClickListener
{
  public aefk(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    new NowVideoReporter().h("video_public").i("search_poi").d(SmallVideoCameraCaptureFragment.a).a(SelectLocationFragment.a(this.a)).b(this.a.getActivity().app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aefk
 * JD-Core Version:    0.7.0.1
 */