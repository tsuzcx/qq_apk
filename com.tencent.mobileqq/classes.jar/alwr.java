import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qqprotect.qsec.ICSProcessor.ICSProcessorListener;

public class alwr
  extends ProtoUtils.TroopProtocolObserver
{
  protected ICSProcessor.ICSProcessorListener a;
  protected byte[] a;
  
  public alwr(byte[] paramArrayOfByte, ICSProcessor.ICSProcessorListener paramICSProcessorListener)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentQqprotectQsecICSProcessor$ICSProcessorListener = paramICSProcessorListener;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentQqprotectQsecICSProcessor$ICSProcessorListener != null) {
      this.jdField_a_of_type_ComTencentQqprotectQsecICSProcessor$ICSProcessorListener.a(paramInt, this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alwr
 * JD-Core Version:    0.7.0.1
 */