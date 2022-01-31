import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;

public class alqz
  implements Runnable
{
  public alqz(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_ADDED >> " + this.jdField_a_of_type_JavaLangString);
    DownloadInfo localDownloadInfo = DownloadDBHelper.a().a(this.b);
    if (localDownloadInfo != null)
    {
      LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_ADDED info != null>> " + localDownloadInfo.toString() + " " + localDownloadInfo.b + " " + localDownloadInfo.d);
      DownloadManager.a().d(localDownloadInfo);
      AppCircleReportManager.a().a(101, localDownloadInfo);
    }
    for (;;)
    {
      DownloadManager.a().a(6, localDownloadInfo);
      return;
      localDownloadInfo = new DownloadInfo("", this.b);
      LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_ADDED info == null>> " + localDownloadInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alqz
 * JD-Core Version:    0.7.0.1
 */