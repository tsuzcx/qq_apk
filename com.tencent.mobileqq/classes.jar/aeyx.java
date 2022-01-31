import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

public class aeyx
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public aeyx(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new aeyy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyx
 * JD-Core Version:    0.7.0.1
 */