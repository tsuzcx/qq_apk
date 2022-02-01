import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.qphone.base.util.QLog;

public class aipr
  implements MediaPlayer.OnErrorListener
{
  public aipr(BlessActivity paramBlessActivity) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onError what=" + paramInt1 + ", extra=" + paramInt2);
    }
    BlessActivity.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipr
 * JD-Core Version:    0.7.0.1
 */