import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.qphone.base.util.QLog;

public class aamc
  implements Runnable
{
  public aamc(ARCloudControl paramARCloudControl, SosoInterface.OnLocationListener paramOnLocationListener) {}
  
  public void run()
  {
    if ((ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl) != null) && (ARCloudControl.e(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      if (!ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl)) {}
    }
    else
    {
      return;
    }
    ARCloudLBSLocationCheckResult localARCloudLBSLocationCheckResult = new ARCloudLBSLocationCheckResult();
    localARCloudLBSLocationCheckResult.a = 2;
    ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a.recognitions, ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl), localARCloudLBSLocationCheckResult);
    if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl) != null) {
      ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).a(0, ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl));
    }
    ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aamc
 * JD-Core Version:    0.7.0.1
 */