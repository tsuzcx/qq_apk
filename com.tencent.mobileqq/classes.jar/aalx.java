import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;

public class aalx
  implements Runnable
{
  public aalx(ARCloudControl paramARCloudControl, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, true);
      ARCloudControl.b(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, true);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a.recognitions == null) {
      return;
    }
    ARFaceDataCollector.a().a();
    ARFaceDataCollector.a().a = System.currentTimeMillis();
    ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalx
 * JD-Core Version:    0.7.0.1
 */