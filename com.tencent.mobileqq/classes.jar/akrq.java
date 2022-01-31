import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.AppNotificationManager.NoticeIdentity;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class akrq
  implements Runnable
{
  public akrq(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    Object localObject1 = AppUtil.b(CommonDataAdapter.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = AppNotificationManager.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          AppNotificationManager.NoticeIdentity localNoticeIdentity = (AppNotificationManager.NoticeIdentity)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localNoticeIdentity != null)
          {
            Object localObject2 = this.a.a(localNoticeIdentity.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).c)))
            {
              localObject2 = this.a.a(((DownloadInfo)localObject2).c);
              if ((localObject2 != null) && (4 != DownloadManager.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                AppNotificationManager.a().a(localNoticeIdentity.a);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrq
 * JD-Core Version:    0.7.0.1
 */