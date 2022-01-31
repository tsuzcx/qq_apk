import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

public class alzb
  extends alzc
{
  public alzb(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void a()
  {
    int j = 0;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a, true);
    e();
    int i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 2, " _run:" + a() + " _running:" + this.jdField_a_of_type_Boolean);
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager) != true) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a, true);
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
            label120:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label120;
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzb
 * JD-Core Version:    0.7.0.1
 */