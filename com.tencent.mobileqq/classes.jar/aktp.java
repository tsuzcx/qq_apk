import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;

public class aktp
  implements Runnable
{
  public aktp(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver.jdField_a_of_type_JavaLangString, "ACTION_PACKAGE_REMOVED >> " + this.jdField_a_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(DownloadConstants.p)))
    {
      DownloadManager.a().a(true);
      MyAppApi.a().f();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.b);
    DownloadManager.a().a(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aktp
 * JD-Core Version:    0.7.0.1
 */