import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;

public class alpw
  implements Runnable
{
  public alpw(MyAppApi paramMyAppApi, Activity paramActivity) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "---isAutoInstall:" + ControlPolicyUtil.c() + " url:" + ControlPolicyUtil.a() + " interval:" + ControlPolicyUtil.a());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((APNUtil.b(this.jdField_a_of_type_AndroidAppActivity)) && (APNUtil.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      bool4 = ApkUtils.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = ControlPolicyUtil.b();
      localUpgradeDetailWrapper = UpgradeController.a().a();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;; bool1 = false)
    {
      boolean bool3 = SPSettings.a();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = SPSettings.a();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo == null)) {
          break label382;
        }
      }
      label382:
      for (int i = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          SPSettings.a(false);
          SPSettings.a(i);
          bool2 = false;
        }
        LogUtility.c("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b()) && (bool5) && (bool1) && (!bool2))
        {
          LogUtility.c("NewUpgradeDialog", "---start pre Download YYB---");
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b = false;
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidOsBundle = null;
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Int = -1;
          MyAppApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi, true);
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        LogUtility.c("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alpw
 * JD-Core Version:    0.7.0.1
 */