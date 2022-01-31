import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class akou
  implements Runnable
{
  public akou(ColorRingPlayer paramColorRingPlayer) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject1 = this.a.jdField_a_of_type_JavaLangObject;
      boolean bool = false;
      try
      {
        if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          bool = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        }
        if ((this.a.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!bool)) {
          break;
        }
        int i = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        int j = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.a.jdField_a_of_type_AndroidOsHandler.post(new akov(this, j, i));
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          this.a.jdField_a_of_type_AndroidMediaMediaPlayer = null;
          this.a.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akou
 * JD-Core Version:    0.7.0.1
 */