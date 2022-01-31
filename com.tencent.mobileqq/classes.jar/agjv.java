import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agjv
  implements Runnable
{
  public agjv(ScanTorchActivity paramScanTorchActivity, ARTarget paramARTarget) {}
  
  public void run()
  {
    ScanTorchActivity.l(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a.e(true);
    ScanTorchActivity.i(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    ScanTorchActivity.j(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    ScanTorchActivity.c(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.l) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.s))
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.k();
      return;
    }
    ScanTorchActivity.b(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.a.a);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjv
 * JD-Core Version:    0.7.0.1
 */