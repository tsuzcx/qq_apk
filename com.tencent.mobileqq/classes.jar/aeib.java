import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart.LocalButtonListenerInterceptor;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryPublishLauncher;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;

public class aeib
  implements View.OnClickListener
{
  public aeib(StoryLocalPublishPart paramStoryLocalPublishPart) {}
  
  public void onClick(View paramView)
  {
    SLog.d("story.publish.StoryLocalPublishPart", "onClick %s", new Object[] { paramView });
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      new NowVideoReporter().h("video_shoot").i("clk_upload").d(SmallVideoCameraCaptureFragment.a).a(1).b(this.a.a().app);
    } while ((StoryLocalPublishPart.a(this.a) != null) && (!StoryLocalPublishPart.a(this.a).a()));
    paramView = StoryPublishLauncher.a();
    Bundle localBundle = this.a.a();
    localBundle.putBoolean("enable_multi_fragment", false);
    localBundle.putInt("local_video_from_type", 1001);
    if (paramView.a())
    {
      paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoCameraCaptureFragment, localBundle, this.a.jdField_a_of_type_Int);
      return;
    }
    throw new AndroidRuntimeException("StoryPublishLauncher is not support");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeib
 * JD-Core Version:    0.7.0.1
 */