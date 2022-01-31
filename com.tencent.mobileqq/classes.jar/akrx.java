import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.concurrent.ConcurrentHashMap;

public class akrx
  implements Runnable
{
  public akrx(DownloadManager paramDownloadManager, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      DownloadDBHelper.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrx
 * JD-Core Version:    0.7.0.1
 */