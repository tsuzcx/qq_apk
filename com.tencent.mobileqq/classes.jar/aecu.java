import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;

public class aecu
  implements agfs
{
  public aecu(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_Aedp != null) {
      this.a.jdField_a_of_type_Aedp.d();
    }
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.a.b(2131694384);
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecu
 * JD-Core Version:    0.7.0.1
 */