import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnInfoListener;

public class aele
  implements IVideoView.OnInfoListener
{
  public aele(VideoPlayerView paramVideoPlayerView) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (paramInt == 21) {
      QualityReporter.f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aele
 * JD-Core Version:    0.7.0.1
 */