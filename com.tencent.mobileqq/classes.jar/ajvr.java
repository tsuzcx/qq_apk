import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

public class ajvr
  implements MediaPlayer.OnCompletionListener
{
  public ajvr(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a != null)
    {
      if (FixedSizeVideoView.a(this.a) != null) {
        FixedSizeVideoView.a(this.a).removeMessages(0);
      }
      this.a.a.a(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvr
 * JD-Core Version:    0.7.0.1
 */