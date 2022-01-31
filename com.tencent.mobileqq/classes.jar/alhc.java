import com.tencent.qqprotect.qsec.CSProcessorImpl;
import com.tencent.qqprotect.qsec.ICSProcessor.ICSProcessorListener;
import com.tencent.qqprotect.qsec.QSecFramework;

public class alhc
  implements ICSProcessor.ICSProcessorListener
{
  protected int a;
  
  public alhc(CSProcessorImpl paramCSProcessorImpl, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_Int != 0) {
      QSecFramework.a(7, this.jdField_a_of_type_Int, paramInt, 0, paramArrayOfByte1, paramArrayOfByte2, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhc
 * JD-Core Version:    0.7.0.1
 */