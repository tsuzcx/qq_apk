import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class acwt
  implements Runnable
{
  public acwt(OfflineSendWorker paramOfflineSendWorker) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "OfflineSendWorker run task sessionid[" + OfflineSendWorker.a(this.a).nSessionId + "],filePath[" + OfflineSendWorker.a(this.a).getFilePath() + "]");
    }
    if (!NetworkUtil.d(BaseApplicationImpl.getContext()))
    {
      OfflineSendWorker.a(this.a, 0);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 2, null);
      OfflineSendWorker.a(this.a, 0L, 9004, "NoNetWork");
      OfflineSendWorker.b(this.a, 0L, 9004, "NoNetWork");
      return;
    }
    OfflineSendWorker.a(this.a, System.currentTimeMillis());
    OfflineSendWorker.a(this.a).status = 2;
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
    localfileAssistantReportData.b = "send_file_number";
    FileManagerReporter.a(OfflineSendWorker.a(this.a).getCurrentAccountUin(), localfileAssistantReportData);
    OfflineSendWorker.a(this.a);
    OfflineSendWorker.a(this.a).a().a(true, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwt
 * JD-Core Version:    0.7.0.1
 */