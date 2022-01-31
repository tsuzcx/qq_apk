import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.downloadnew.DownloadApi;

public final class akqo
  implements DialogInterface.OnClickListener
{
  public akqo(Bundle paramBundle, int paramInt, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    ReportController.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101;
    AppCircleReportManager.a().a(25, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akqo
 * JD-Core Version:    0.7.0.1
 */