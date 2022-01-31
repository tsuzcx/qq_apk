import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk;
import com.tencent.qphone.base.util.QLog;

public class aczo
  implements Runnable
{
  public aczo(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
    UniformDownloaderAppBabySdk.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczo
 * JD-Core Version:    0.7.0.1
 */