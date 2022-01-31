import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class akjg
  implements MediaPlayer.OnPreparedListener
{
  akjg(akje paramakje) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + akje.b(this.a));
      }
      this.a.a.seekTo(0);
      akje.b(this.a, true);
      if (akje.b(this.a))
      {
        this.a.a.start();
        akje.c(this.a, false);
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
 * Qualified Name:     akjg
 * JD-Core Version:    0.7.0.1
 */