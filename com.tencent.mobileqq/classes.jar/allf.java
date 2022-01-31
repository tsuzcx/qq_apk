import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.MyAppDialog;

public class allf
  implements DialogInterface.OnClickListener
{
  public allf(AppInterface paramAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if (paramInt == 2131428542)
    {
      StaticAnalyz.a("200", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
      paramDialogInterface = CommonDataAdapter.a().a().getSharedPreferences("package_scan", 0).edit();
      paramDialogInterface.putBoolean("qqsetting_package_scan_flag", false);
      paramDialogInterface.commit();
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog != null) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.dismiss();
      }
      paramDialogInterface = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + this.jdField_a_of_type_JavaLangString + "','r':'0','data':'0'});}void(0);";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.mHandler.post(new allg(this, paramDialogInterface));
      return;
      if (paramInt == 2131428541)
      {
        if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog != null) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog.dismiss();
        }
        paramDialogInterface = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + this.jdField_a_of_type_JavaLangString + "','r':'0','data':'1'});}void(0);";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     allf
 * JD-Core Version:    0.7.0.1
 */