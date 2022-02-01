import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;

public class adoh
  implements afpx
{
  public adoh(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_Adpc != null) {
      this.a.jdField_a_of_type_Adpc.d();
    }
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.a.b(2131694699);
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
 * Qualified Name:     adoh
 * JD-Core Version:    0.7.0.1
 */