import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.config.WorldCupReport;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agjh
  implements View.OnClickListener
{
  public agjh(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onClick(View paramView)
  {
    ScanTorchActivity.y(this.a, true);
    ScanTorchActivity.a(this.a, "operateBtnOnClick", false);
    ScanTorchActivity.A(this.a);
    if (!ScanTorchActivity.j(this.a)) {
      ScanTorchActivity.h(this.a);
    }
    do
    {
      return;
      WorldCupReport.b();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a().a() == 0))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(324);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(324);
        return;
      }
    } while (((this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a().a() == 1)) || (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null) || (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a() == null) || (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a().a() != 2));
    ScanTorchActivity.a(this.a, "operateBtn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjh
 * JD-Core Version:    0.7.0.1
 */