import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.utils.AudioUtil;

public final class ajnm
  implements Runnable
{
  public ajnm(MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    this.a.onCompletion(AudioUtil.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajnm
 * JD-Core Version:    0.7.0.1
 */