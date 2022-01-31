import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;

public class algw
  implements Runnable
{
  public algw(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = null;
    if (UpdateManager.a()) {
      UpdateManager.a().a();
    }
    if (MyAppApi.d()) {
      MyAppApi.a().h();
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     algw
 * JD-Core Version:    0.7.0.1
 */