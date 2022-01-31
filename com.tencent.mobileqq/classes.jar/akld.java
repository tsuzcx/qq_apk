import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;

public final class akld
  implements MediaPlayer.OnCompletionListener
{
  public akld(VideoView paramVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akld
 * JD-Core Version:    0.7.0.1
 */