import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.qphone.base.util.QLog;

public class ahcl
  implements MediaPlayer.OnCompletionListener
{
  public ahcl(BlessActivity paramBlessActivity) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onCompletion");
    }
    BlessActivity.a(this.a, true);
    azqs.b(this.a.app, "CliOper", "", "", "0X800632E", "0X800632E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcl
 * JD-Core Version:    0.7.0.1
 */