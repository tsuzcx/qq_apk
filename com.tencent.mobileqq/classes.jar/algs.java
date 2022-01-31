import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class algs
  implements Runnable
{
  public algs(DownloadManager paramDownloadManager, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().pauseDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     algs
 * JD-Core Version:    0.7.0.1
 */