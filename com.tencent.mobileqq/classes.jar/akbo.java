import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public final class akbo
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    com.tencent.mobileqq.utils.AudioUtil.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbo
 * JD-Core Version:    0.7.0.1
 */