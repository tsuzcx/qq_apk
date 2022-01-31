import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.aio.AudioPlayer;

public class aaqz
  implements actw
{
  public aaqz(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_Aaru != null) {
      this.a.jdField_a_of_type_Aaru.d();
    }
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.b(2131695204);
    this.a.setVolumeControlStream(3);
    this.a.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.a);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqz
 * JD-Core Version:    0.7.0.1
 */