import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class aghl
  implements Runnable
{
  public aghl(ScanTorchActivity paramScanTorchActivity, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ScanTorchActivity.r(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.runOnUiThread(new aghm(this));
      return;
      Pair localPair = ScannerView.a(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.getBaseContext());
      if (localPair != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "scan photo QRCode finish");
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("scannerResult", String.valueOf(localPair.first).trim());
        localIntent.putExtra("scannerType", String.valueOf(localPair.second).trim());
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.setResult(13, localIntent);
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.finish();
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.overridePendingTransition(0, 0);
        return;
      }
      ScanTorchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghl
 * JD-Core Version:    0.7.0.1
 */