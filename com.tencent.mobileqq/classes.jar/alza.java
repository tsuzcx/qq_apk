import android.media.AudioManager;
import com.tencent.av.AVLog;
import com.tencent.sharp.jni.TraeAudioManager;

public class alza
  extends alzc
{
  public alza(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_WIREDHEADSET";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, false);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setWiredHeadsetOn(true);
    e();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager)) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, false);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            AVLog.e("TraeAudioManager", localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alza
 * JD-Core Version:    0.7.0.1
 */