import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import mqq.os.MqqHandler;

public class aeln
  implements TVK_IMediaPlayer.OnErrorListener
{
  public aeln(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoViewTVKImpl", 2, "onError called with: tvk_iMediaPlayer = [" + paramTVK_IMediaPlayer + "], model = [" + paramInt1 + "], what = [" + paramInt2 + "], position = [" + paramInt3 + "], extra = [" + paramString + "], Info = [" + paramObject + "]");
    }
    ThreadManager.getUIHandler().post(new aelo(this, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeln
 * JD-Core Version:    0.7.0.1
 */