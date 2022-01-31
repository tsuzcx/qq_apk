import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aacs
  extends HttpEngineTask
{
  public aacs(ARPreSoResourceDownload paramARPreSoResourceDownload, QQAppInterface paramQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    super(paramQQAppInterface, paramString, paramIHttpEngineTask, paramHttpNetReq);
  }
  
  protected void a()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload))
    {
      ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).get(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.b);
      if (localARResourceDownloadCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback.a();
      }
      super.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aacs
 * JD-Core Version:    0.7.0.1
 */