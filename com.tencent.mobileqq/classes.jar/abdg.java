import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.qphone.base.util.QLog;

public class abdg
  implements IArConfigListener
{
  public abdg(ShopScanActivity paramShopScanActivity) {}
  
  public void a()
  {
    ArConfigInfo localArConfigInfo = ArConfigInfo.parseArConfig(ShopScanActivity.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onArManagerReady config: " + localArConfigInfo);
    }
    if (localArConfigInfo != null) {
      localArConfigInfo.saveConfig = false;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a(localArConfigInfo);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onDownloadError error = ", Integer.valueOf(paramInt) });
    }
    this.a.e.setVisibility(4);
    this.a.b.setVisibility(8);
    this.a.f.setVisibility(8);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onDownloadProcess");
    }
    if (!ShopScanActivity.b(this.a)) {
      return;
    }
    int i = (int)(100L * paramLong1 / paramLong2);
    if (this.a.b.getVisibility() != 0)
    {
      this.a.b.setVisibility(0);
      if (this.a.e != null) {
        this.a.e.setVisibility(8);
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    this.a.g.setText(this.a.getResources().getString(2131438497));
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo) {}
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onArConfigChanged arConfigInfo = ", paramArConfigInfo });
    }
    if (paramArConfigInfo != null)
    {
      ShopScanActivity.a(this.a, paramArConfigInfo);
      ShopScanActivity.a(this.a);
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, new Object[] { "onEffectConfigChanged arEffectConfig = ", paramArEffectConfig });
    }
    ShopScanActivity.a(this.a, paramArEffectConfig);
    ARDeviceController.a().a(ShopScanActivity.a(this.a));
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = ARDeviceController.a().b();
    paramArEffectConfig = ARDeviceController.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "isAREnable: " + bool1 + ", isSupportAr: " + bool2 + ", gpu: " + paramArEffectConfig);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanActivity", 2, "onDownloadSuccess");
    }
    if (this.a.d.getVisibility() == 0)
    {
      this.a.d.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ShopScanActivity.b(this.a);
      ShopScanActivity.a(this.a, true);
    }
    while ((ShopScanActivity.a(this.a)) || (this.a.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdg
 * JD-Core Version:    0.7.0.1
 */