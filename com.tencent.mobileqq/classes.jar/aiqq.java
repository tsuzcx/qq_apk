import android.media.MediaPlayer;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class aiqq
  implements Runnable
{
  public aiqq(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    if ((this.a.g) && (this.a.a != null) && (!this.a.a.isPlaying())) {
      this.a.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqq
 * JD-Core Version:    0.7.0.1
 */