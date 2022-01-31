import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;

public class aehm
  implements View.OnClickListener
{
  public aehm(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    if (SmallVideoSendFragment.a(this.a).h == 0) {}
    for (int i = 1;; i = 2)
    {
      paramView.putExtra("content_type", i);
      paramView.putExtra("selected_location", this.a.a.a());
      PublicFragmentActivity.a(this.a.getActivity(), paramView, SelectLocationFragment.class, 1001);
      new NowVideoReporter().h("video_public").i("clk_poi").d(SmallVideoSendFragment.a(this.a)).a(i).b(this.a.getActivity().app);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aehm
 * JD-Core Version:    0.7.0.1
 */