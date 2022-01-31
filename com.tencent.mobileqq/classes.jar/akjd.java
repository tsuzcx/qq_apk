import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.utils.AudioUtil;

public final class akjd
  implements MediaPlayer.OnCompletionListener
{
  public akjd(MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (AudioUtil.b() == 0)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null)
      {
        if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.getLooper() == Looper.myLooper()))
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(AudioUtil.a);
          return;
        }
        AudioUtil.a();
        this.jdField_a_of_type_AndroidOsHandler.post(new akje(this));
        return;
      }
      AudioUtil.a();
      return;
    }
    AudioUtil.c();
    AudioUtil.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akjd
 * JD-Core Version:    0.7.0.1
 */