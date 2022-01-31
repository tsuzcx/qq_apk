import com.tencent.mobileqq.ark.ArkAppCGI;
import java.util.ArrayList;

public class aaly
  implements Runnable
{
  public aaly(ArkAppCGI paramArkAppCGI, aamh paramaamh, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI))
    {
      ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI).remove(this.jdField_a_of_type_Aamh);
      this.jdField_a_of_type_Aamh.a.a(this.jdField_a_of_type_Aamh, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaly
 * JD-Core Version:    0.7.0.1
 */