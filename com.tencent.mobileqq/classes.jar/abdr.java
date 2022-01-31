import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class abdr
  implements TVK_SDKMgr.InstallListener
{
  public abdr(ShopScanActivity paramShopScanActivity) {}
  
  public void onInstallProgress(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 1, "onInstallProgress progress: " + paramFloat);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 1, "onInstalledFailed");
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onInstalledSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdr
 * JD-Core Version:    0.7.0.1
 */