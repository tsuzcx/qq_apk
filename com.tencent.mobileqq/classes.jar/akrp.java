import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class akrp
  implements ITMAssistantDownloadLogListener
{
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
  
  public akrp(DownloadManager paramDownloadManager) {}
  
  public void onLog(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.i(DownloadManager.a, 2, "logList is null");
      }
    }
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TMAssistantDownloadLogInfo localTMAssistantDownloadLogInfo = (TMAssistantDownloadLogInfo)paramArrayList.next();
        if (QLog.isColorLevel()) {
          QLog.i(DownloadManager.a, 2, "logTime:" + this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(localTMAssistantDownloadLogInfo.logTime)) + ",logTag:" + localTMAssistantDownloadLogInfo.logTag + ",logMsg:" + localTMAssistantDownloadLogInfo.logMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrp
 * JD-Core Version:    0.7.0.1
 */