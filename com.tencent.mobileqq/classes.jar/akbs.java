import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.utils.AudioUtil;

public final class akbs
  implements Runnable
{
  public akbs(MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    this.a.onCompletion(AudioUtil.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbs
 * JD-Core Version:    0.7.0.1
 */