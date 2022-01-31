import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import java.io.File;

public class aktk
  implements Runnable
{
  public aktk(UpdateManager paramUpdateManager, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c = l;
        DownloadManager.a().g(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        return;
      }
      LogUtility.c(UpdateManager.jdField_a_of_type_JavaLangString, "patchNewApk file not exists");
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(UpdateManager.jdField_a_of_type_JavaLangString, "patchNewApk>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aktk
 * JD-Core Version:    0.7.0.1
 */