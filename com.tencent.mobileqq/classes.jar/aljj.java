import com.tencent.sharp.jni.TraeAudioManager;

public class aljj
  extends aljm
{
  public aljj(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_EARPHONE";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a, false);
    e();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager)) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a, false);
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
            label69:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label69;
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aljj
 * JD-Core Version:    0.7.0.1
 */