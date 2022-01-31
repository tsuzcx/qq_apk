import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agkn
  implements Runnable
{
  public agkn(ScanTorchActivity paramScanTorchActivity, ARTarget paramARTarget) {}
  
  public void run()
  {
    ScanTorchActivity.i(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    ScanTorchActivity.j(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    ScanTorchActivity.k(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    ScanTorchActivity.c(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, false);
    if (((!ARVideoRecordUIControllerImpl.a().a()) || (ARVideoRecordUIControllerImpl.a().b())) && (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.a()) && (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c()) && (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.b()))
    {
      ARVideoRecordUIControllerImpl.a().c();
      ARVideoRecordUIControllerImpl.a().e();
      QLog.d("ScanTorchActivity", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.a())
    {
      ARVideoRecordUIControllerImpl.a().d();
      QLog.d("ScanTorchActivity", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
      return;
    }
    QLog.d("ScanTorchActivity", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkn
 * JD-Core Version:    0.7.0.1
 */