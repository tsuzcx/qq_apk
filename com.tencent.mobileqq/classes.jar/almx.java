import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class almx
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public almx(QRScanEntryView paramQRScanEntryView, String paramString1, String paramString2) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = new Intent();
      paramBundle.putExtra("detectType", 2);
      paramBundle.putExtra("scannerResult", this.jdField_a_of_type_JavaLangString.trim());
      paramBundle.putExtra("filePath", this.b);
      ((Activity)this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView.jdField_a_of_type_AndroidContentContext).setResult(13, paramBundle);
      ((Activity)this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView.jdField_a_of_type_AndroidContentContext).finish();
      ((Activity)this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_QRScanEntryView", 2, "onLaunchResult 2 false");
    }
    ((alla)this.jdField_a_of_type_ComTencentMobileqqArViewQRScanEntryView.jdField_a_of_type_Alkn).b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     almx
 * JD-Core Version:    0.7.0.1
 */