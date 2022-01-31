import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.ArrayList;
import java.util.List;

public final class algl
  implements Runnable
{
  public algl(String paramString, DownloadQueryListener paramDownloadQueryListener) {}
  
  public void run()
  {
    LogUtility.a(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = DownloadManager.a().b(this.jdField_a_of_type_JavaLangString);
      LogUtility.a(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia result = " + localList);
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener != null) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.b_(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        LogUtility.c(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener == null);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     algl
 * JD-Core Version:    0.7.0.1
 */