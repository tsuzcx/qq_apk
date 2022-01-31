import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class aeyv
  implements TVK_IMediaPlayer.OnInfoListener
{
  public aeyv(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoViewTVKImpl", 2, "onInfo what=" + paramInt + "  ex:" + paramObject);
    }
    ThreadManager.getUIHandler().post(new aeyw(this, paramInt, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyv
 * JD-Core Version:    0.7.0.1
 */