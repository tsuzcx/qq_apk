import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.qphone.base.util.QLog;

public class abbx
  implements MediaPlayer.OnPreparedListener
{
  public abbx(ARMapManager paramARMapManager) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((ARMapManager.a(this.a) == 0) && (paramMediaPlayer != null)) {}
    try
    {
      paramMediaPlayer.start();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ARMapManager", 2, "playMapBGSound2-----" + paramMediaPlayer.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbx
 * JD-Core Version:    0.7.0.1
 */