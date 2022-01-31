import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.data.MessageForPtt;

public class acxe
  implements MediaPlayer.OnCompletionListener
{
  public acxe(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    bbcf.a = null;
    if ((MediaPlayerManager.a(this.a) != null) && ((MediaPlayerManager.a(this.a) instanceof MessageForPtt))) {
      ((MessageForPtt)MediaPlayerManager.a(this.a)).playProgress = 0.0F;
    }
    if ((MediaPlayerManager.a(this.a) != null) && (MediaPlayerManager.a(this.a))) {
      return;
    }
    MediaPlayerManager.a(this.a, null);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxe
 * JD-Core Version:    0.7.0.1
 */