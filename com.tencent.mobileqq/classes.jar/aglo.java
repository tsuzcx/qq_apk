import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class aglo
  implements Runnable
{
  public aglo(ScanTorchActivity paramScanTorchActivity, int paramInt) {}
  
  public void run()
  {
    if (!ScanTorchActivity.h(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity)) {
      if (this.jdField_a_of_type_Int > ScanEntranceDPC.a().c) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      if (ScanTorchActivity.g(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity) != bool)
      {
        ScanTorchActivity.o(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, bool);
        ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglo
 * JD-Core Version:    0.7.0.1
 */