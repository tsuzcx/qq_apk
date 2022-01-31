import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class acbi
  implements Runnable
{
  public acbi(FeedsManager paramFeedsManager) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int i = FeedsManager.access$000(this.a).a(new FeedInfo().getTableName(), "feedTime<?", new String[] { String.valueOf(l - 604800L) });
    if (QLog.isColorLevel()) {
      QLog.i("FeedsManager", 2, String.format("删除 %d 条 7天前的feeds记录", new Object[] { Integer.valueOf(i) }));
    }
    Object localObject = (ArrayList)FeedsManager.access$000(this.a).a(FeedInfo.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FeedInfo localFeedInfo = (FeedInfo)((Iterator)localObject).next();
        this.a.feedInfoCache.put(String.valueOf(localFeedInfo.ownerUin), localFeedInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbi
 * JD-Core Version:    0.7.0.1
 */