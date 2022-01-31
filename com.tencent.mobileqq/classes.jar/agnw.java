import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agnw
  implements Runnable
{
  public agnw(ScanTorchActivity paramScanTorchActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ScanTorchActivity.c(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).setVisibility(0);
    ScanTorchActivity.b(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).setVisibility(0);
    ScanTorchActivity.b(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).setVisibility(8);
    ScanTorchActivity.b(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).setVisibility(0);
    ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).setVisibility(8);
    ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      ScanTorchActivity.z(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, this.b);
    }
    for (;;)
    {
      ScanTorchActivity.c(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, true);
      ScanTorchActivity.k(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
      return;
      ScanTorchActivity.z(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a.b(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnw
 * JD-Core Version:    0.7.0.1
 */