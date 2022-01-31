import android.media.MediaPlayer;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class agfm
  implements Runnable
{
  public agfm(AmrPlayer paramAmrPlayer) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr " + AmrPlayer.a(this.a));
    }
    try
    {
      AmrPlayer.a(this.a).b();
      AmrPlayer.a(this.a).start();
      if (AmrPlayer.a(this.a, AmrPlayer.a(this.a) - 1000) > 0) {
        AmrPlayer.a(this.a).seekTo(AmrPlayer.a(this.a));
      }
      return;
    }
    catch (Exception localException)
    {
      while (AmrPlayer.a(this.a) == null) {}
      AmrPlayer.a(this.a).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agfm
 * JD-Core Version:    0.7.0.1
 */