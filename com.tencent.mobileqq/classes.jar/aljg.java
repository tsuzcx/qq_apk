import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;

public class aljg
  implements Runnable
{
  public aljg(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_REPLACED >> " + this.jdField_a_of_type_JavaLangString);
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    DownloadManager.a().a(13, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljg
 * JD-Core Version:    0.7.0.1
 */