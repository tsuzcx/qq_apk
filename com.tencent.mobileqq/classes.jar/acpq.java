import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class acpq
  implements Runnable
{
  public acpq(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    try
    {
      if (UniformDownloadMgr.a(this.a) != null)
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(UniformDownloadMgr.a(this.a));
        UniformDownloadMgr.a(this.a, null);
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST");
        return;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST, had unRegister");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpq
 * JD-Core Version:    0.7.0.1
 */