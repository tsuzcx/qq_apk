import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class ainr
  implements MediaPlayer.OnErrorListener
{
  ainr(ainq paramainq) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("CmGameAudioPlayer", 1, "what " + paramInt1 + " ext " + paramInt2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ainr
 * JD-Core Version:    0.7.0.1
 */