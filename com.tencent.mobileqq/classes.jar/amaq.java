import android.content.pm.PackageInfo;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class amaq
  implements Manager
{
  private QQAppInterface a;
  
  public amaq(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    ThreadManagerV2.executeOnFileThread(new RockDownloaderManager.1(this));
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = bbio.a(this.a.getApp());
    Object localObject1 = new HashMap();
    Object localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PackageInfo)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(((PackageInfo)localObject3).packageName, Integer.valueOf(((PackageInfo)localObject3).versionCode));
      }
    }
    localObject2 = aman.a().a(RockDownloadInfo.class);
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (RockDownloadInfo)((Iterator)localObject2).next();
        Object localObject4;
        if (((RockDownloadInfo)localObject3).endTime + 604800L < l / 1000L)
        {
          localObject4 = new VFSFile(((RockDownloadInfo)localObject3).localPath);
          if (((VFSFile)localObject4).exists()) {
            ((VFSFile)localObject4).delete();
          }
          aman.a().b((aukm)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("RockDownloaderManager", 2, new Object[] { "remove info because has overdue", localObject3 });
          }
        }
        else if (((HashMap)localObject1).containsKey(((RockDownloadInfo)localObject3).getPackageName()))
        {
          localObject4 = (Integer)((HashMap)localObject1).get(((RockDownloadInfo)localObject3).getPackageName());
          if ((localObject4 != null) && (((RockDownloadInfo)localObject3).realVersionCode > 0) && (((Integer)localObject4).intValue() >= ((RockDownloadInfo)localObject3).realVersionCode))
          {
            localObject4 = new VFSFile(((RockDownloadInfo)localObject3).localPath);
            if (((VFSFile)localObject4).exists()) {
              ((VFSFile)localObject4).delete();
            }
            aman.a().b((aukm)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloaderManager", 2, new Object[] { "remove info because has install", localObject3 });
            }
          }
        }
      }
    }
    localObject1 = new VFSFile(aman.a());
    if (((VFSFile)localObject1).exists())
    {
      localObject1 = ((VFSFile)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (((VFSFile)localObject2).lastModified() + 604800000L < l)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloaderManager", 2, new Object[] { "remove file", ((VFSFile)localObject2).getAbsolutePath() });
            }
            ((VFSFile)localObject2).delete();
          }
          i += 1;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amaq
 * JD-Core Version:    0.7.0.1
 */