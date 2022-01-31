import android.os.Handler;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnCompletionListener;

public class afdg
  implements IVideoView.OnCompletionListener
{
  public afdg(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener.a();
    }
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
    paramIVideoView = VideoPlayerView.a(this.a).a;
    if (this.a.c()) {}
    for (int i = 1;; i = 2)
    {
      QualityReporter.a(paramIVideoView, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdg
 * JD-Core Version:    0.7.0.1
 */