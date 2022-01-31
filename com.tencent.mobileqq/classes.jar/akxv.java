import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class akxv
  implements MediaPlayer.OnPreparedListener
{
  akxv(akxq paramakxq) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + akxq.b(this.a));
      }
      this.a.a.seekTo(0);
      akxq.b(this.a, true);
      if (akxq.b(this.a))
      {
        this.a.a.start();
        akxq.c(this.a, false);
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
 * Qualified Name:     akxv
 * JD-Core Version:    0.7.0.1
 */