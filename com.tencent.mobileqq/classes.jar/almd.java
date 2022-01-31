import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.2;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class almd
  extends ally
{
  public almd(RockDownloaderManager.2 param2) {}
  
  public void a(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloaderManager", 2, new Object[] { "onFail: RockDownloadInfo=", paramRockDownloadInfo, " errorMsg=", paramString, " errorCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(ArrayList<RockDownloadInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramArrayList.next();
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloaderManager", 2, new Object[] { "onSuccess:", localRockDownloadInfo });
      }
      boolean bool = alme.b(localRockDownloadInfo);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloaderManager", 2, new Object[] { "install success=", Boolean.valueOf(bool) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     almd
 * JD-Core Version:    0.7.0.1
 */