import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.CopyAndInstallTask;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;
import com.tencent.open.downloadnew.MyAppDialog;

public class alik
  implements DialogInterface.OnClickListener
{
  public alik(MyAppApi paramMyAppApi, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b())
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(0, 1);
        }
      }
    }
    label409:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
      StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
      paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 100;
      AppCircleReportManager.a().a(25, paramDialogInterface);
      ReportController.b(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
      return;
      new MyAppApi.CopyAndInstallTask(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams).execute(new Void[0]);
      continue;
      if ((ControlPolicyUtil.h()) || (this.c)) {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog == null) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          break label409;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
        break;
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        continue;
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alik
 * JD-Core Version:    0.7.0.1
 */