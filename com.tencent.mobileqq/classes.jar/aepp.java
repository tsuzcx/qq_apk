import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.AudioPlayer;

public class aepp
  extends Handler
{
  public aepp(AudioPlayer paramAudioPlayer) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (AudioPlayer.a(this.a) == 0) && (this.a.a()))
    {
      int i = AudioPlayer.a(this.a).getStreamVolume(AudioPlayer.a(this.a).b);
      int j = AudioPlayer.a(this.a).getStreamMaxVolume(AudioPlayer.a(this.a).b);
      if (i / j <= 0.18F) {
        break label126;
      }
      AudioPlayer.a(this.a, 1);
      if (AudioPlayer.a(this.a) != null) {
        AudioPlayer.a(this.a).c(this.a, AudioPlayer.a(this.a));
      }
    }
    return;
    label126:
    AudioPlayer.a(this.a).sendEmptyMessageDelayed(1000, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepp
 * JD-Core Version:    0.7.0.1
 */