import android.media.MediaPlayer;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class ahxs
  implements Runnable
{
  public ahxs(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    if ((this.a.g) && (this.a.a != null) && (!this.a.a.isPlaying())) {
      this.a.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahxs
 * JD-Core Version:    0.7.0.1
 */