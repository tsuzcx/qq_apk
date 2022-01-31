import android.os.Handler;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class abld
  implements TVK_SDKMgr.InstallListener
{
  public abld(ShopScanActivity paramShopScanActivity) {}
  
  public void onInstallProgress(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 1, "video sdk, onInstallProgress, v=" + paramFloat + ", mVideoSdkInstallCancel=" + ShopScanActivity.c(this.a));
    }
    if ((ShopScanActivity.a(this.a)) || (ShopScanActivity.c(this.a))) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new ablh(this, paramFloat));
  }
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 1, "video sdk, onInstalledFailed, i=" + paramInt + ", mVideoSdkInstallCancel=" + ShopScanActivity.c(this.a));
    }
    if ((ShopScanActivity.a(this.a)) || (ShopScanActivity.c(this.a))) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new ablg(this));
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "video sdk, onInstalledSuccessed, mVideoSdkInstallCancel=" + ShopScanActivity.c(this.a));
    }
    if ((ShopScanActivity.a(this.a)) || (ShopScanActivity.c(this.a))) {
      return;
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a())
    {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new able(this));
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new ablf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abld
 * JD-Core Version:    0.7.0.1
 */