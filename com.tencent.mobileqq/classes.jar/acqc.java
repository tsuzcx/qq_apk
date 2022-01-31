import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.SucDownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;
import com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class acqc
  implements Runnable
{
  public acqc(UniformDownloadPkgInstallReceiver paramUniformDownloadPkgInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = UniformDownloadMgr.a().a(this.b, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          UniformDownloadMgr.SucDownloadInfo localSucDownloadInfo = (UniformDownloadMgr.SucDownloadInfo)((Iterator)localObject).next();
          if (localSucDownloadInfo != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.b + " notificationId:" + localSucDownloadInfo.a);
            UniformDownloadNfn.a().c(localSucDownloadInfo.a, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqc
 * JD-Core Version:    0.7.0.1
 */