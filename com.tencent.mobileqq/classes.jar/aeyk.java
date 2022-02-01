import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;

public class aeyk
  extends Handler
{
  public aeyk(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (this.a.d == 0) && (this.a.a()))
    {
      int i = this.a.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.a.jdField_a_of_type_Bfts.b);
      int j = this.a.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.a.jdField_a_of_type_Bfts.b);
      if (i / j <= 0.18F) {
        break label125;
      }
      this.a.d = 1;
      if (this.a.jdField_a_of_type_Aeyl != null) {
        this.a.jdField_a_of_type_Aeyl.c(this.a, this.a.d);
      }
    }
    return;
    label125:
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyk
 * JD-Core Version:    0.7.0.1
 */