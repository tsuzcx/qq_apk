import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.shortvideo.videoplayer.AIOBubbleVideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class acvu
  implements awnb
{
  public acvu(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public boolean a(AIOBubbleVideoView paramAIOBubbleVideoView, TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    while (paramAIOBubbleVideoView != null)
    {
      if (paramAIOBubbleVideoView == AIOLongShotHelper.a(this.a)) {
        return true;
      }
      paramAIOBubbleVideoView = (View)paramAIOBubbleVideoView.getParent();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvu
 * JD-Core Version:    0.7.0.1
 */