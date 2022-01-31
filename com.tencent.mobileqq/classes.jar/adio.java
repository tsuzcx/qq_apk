import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;

public class adio
  implements TVK_IMediaPlayer.OnVideoPreparingListener
{
  public adio(VideoBaseItem paramVideoBaseItem) {}
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoBaseItem", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adio
 * JD-Core Version:    0.7.0.1
 */