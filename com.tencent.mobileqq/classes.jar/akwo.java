import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class akwo
  implements MediaPlayer.OnErrorListener
{
  akwo(akwn paramakwn) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("CmGameAudioPlayer", 1, "what " + paramInt1 + " ext " + paramInt2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwo
 * JD-Core Version:    0.7.0.1
 */