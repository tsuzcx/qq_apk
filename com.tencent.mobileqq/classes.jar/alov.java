import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloaderGetCodeClient;

public class alov
  implements Runnable
{
  public alov(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      LogUtility.c(DownloadManager.a, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d + " begin getApkCode ......");
      DownloaderGetCodeClient.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alov
 * JD-Core Version:    0.7.0.1
 */