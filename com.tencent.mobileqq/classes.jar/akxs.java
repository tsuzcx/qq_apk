import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class akxs
  implements MediaPlayer.OnErrorListener
{
  akxs(akxp paramakxp) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ARMusicController", 2, "ARMusicController, onError, what=" + paramInt1 + ", extra=" + paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxs
 * JD-Core Version:    0.7.0.1
 */