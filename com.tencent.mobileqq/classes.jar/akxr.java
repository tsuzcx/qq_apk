import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class akxr
  implements MediaPlayer.OnPreparedListener
{
  akxr(akxp paramakxp) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + akxp.b(this.a));
      }
      this.a.a.seekTo(0);
      akxp.b(this.a, true);
      if (akxp.b(this.a))
      {
        this.a.a.start();
        akxp.c(this.a, false);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxr
 * JD-Core Version:    0.7.0.1
 */