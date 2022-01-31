import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class agkr
  implements Runnable
{
  public agkr(ScanTorchActivity paramScanTorchActivity, ARTarget paramARTarget, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b)
      {
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.b, "1", "1", "");
        ScanTorchActivity.l(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, true);
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a.e(true);
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a.a(1L);
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a.b();
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.k();
      }
    }
    do
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.b, "1", "0", "");
      String str = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.setResult(11);
      ARVideoRecordUIControllerImpl.a().b(2);
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.a(str));
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.startActivity(localIntent);
      if ((ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity) != null) && (!ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).a.d())) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.b.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.b.getCurrentAccountUin(), ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity).a.b, "2");
      }
      ScanTorchActivity.m(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, true);
      return;
      ScanTorchActivity.j(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    } while (!this.jdField_a_of_type_Boolean);
    ScanTorchActivity.m(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkr
 * JD-Core Version:    0.7.0.1
 */