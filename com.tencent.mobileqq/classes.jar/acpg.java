import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class acpg
  implements Runnable
{
  public acpg(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    try
    {
      if (UniformDownloadMgr.a(this.a) == null)
      {
        UniformDownloadMgr.a(this.a, new acph(this));
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qfile_unifromdownload");
        BaseApplicationImpl.getApplication().registerReceiver(UniformDownloadMgr.a(this.a), localIntentFilter);
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr Register UNIDOWNLOAD_BORDCAST");
        return;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppInit, but mRecv is already setted");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpg
 * JD-Core Version:    0.7.0.1
 */