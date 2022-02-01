import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessActivity.7.1;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;

public class aipp
  implements MediaPlayer.OnPreparedListener
{
  public aipp(BlessActivity paramBlessActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onPrepared");
    }
    if (BlessActivity.a(this.a) != null) {
      BlessActivity.a(this.a).start();
    }
    BlessActivity.a(this.a).postDelayed(new BlessActivity.7.1(this), 800L);
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onPrepared");
    }
    bdla.b(this.a.app, "CliOper", "", "", "0X800632D", "0X800632D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipp
 * JD-Core Version:    0.7.0.1
 */