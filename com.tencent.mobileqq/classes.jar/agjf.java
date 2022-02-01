import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

public class agjf
  implements MediaPlayer.OnCompletionListener
{
  public agjf(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[SilkPlayer]mFinishListener, onCompletion , mp == null ? ");
      if (paramMediaPlayer != null) {
        break label109;
      }
    }
    label109:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("MediaPlayerManager", 2, bool);
      bhkm.a = null;
      if ((MediaPlayerManager.a(this.a) != null) && ((MediaPlayerManager.a(this.a) instanceof MessageForPtt))) {
        ((MessageForPtt)MediaPlayerManager.a(this.a)).playProgress = 0.0F;
      }
      if ((MediaPlayerManager.a(this.a) == null) || (!MediaPlayerManager.a(this.a))) {
        break;
      }
      return;
    }
    MediaPlayerManager.a(this.a, null);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjf
 * JD-Core Version:    0.7.0.1
 */