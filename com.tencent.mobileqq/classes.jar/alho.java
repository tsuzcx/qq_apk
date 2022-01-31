import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class alho
  implements Runnable
{
  public alho(DownloadManager paramDownloadManager, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().deleteDownloadTask(this.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().cancelDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alho
 * JD-Core Version:    0.7.0.1
 */