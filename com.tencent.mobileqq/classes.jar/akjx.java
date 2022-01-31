import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReportHandler;
import com.tencent.mobileqq.data.PushBannerReportLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.JumpAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class akjx
  extends Thread
{
  public akjx(JumpAction paramJumpAction) {}
  
  public void run()
  {
    Object localObject1 = (String)JumpAction.a(this.a).get("version");
    Object localObject3 = ReportHandler.a(this.a.b, this.a.c, (String)localObject1, "");
    localObject1 = JumpAction.a(this.a).getEntityManagerFactory().createEntityManager();
    Object localObject4 = ((EntityManager)localObject1).a(PushBannerReportLog.class);
    Object localObject2;
    if ((localObject4 != null) && (((List)localObject4).size() >= 9))
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
      localObject3 = ((List)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PushBannerReportLog)((Iterator)localObject3).next();
        if (((HashMap)localObject2).containsKey(((PushBannerReportLog)localObject4).getLog())) {
          ((HashMap)localObject2).put(((PushBannerReportLog)localObject4).getLog(), Integer.valueOf(((Integer)((HashMap)localObject2).get(((PushBannerReportLog)localObject4).getLog())).intValue() + 1));
        } else {
          ((HashMap)localObject2).put(((PushBannerReportLog)localObject4).getLog(), Integer.valueOf(1));
        }
      }
      localObject3 = new ArrayList();
      localObject4 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
        String str = (String)((Map.Entry)localObject5).getKey();
        localObject5 = (Integer)((Map.Entry)localObject5).getValue();
        ((List)localObject3).add(str + "|" + localObject5);
      }
      localObject4 = JumpAction.a(this.a);
      JumpAction.a(this.a);
      ((ReportHandler)((QQAppInterface)localObject4).a(5)).a((String[])((List)localObject3).toArray(new String[((List)localObject3).size()]));
      ((EntityManager)localObject1).a(PushBannerReportLog.class);
      ((HashMap)localObject2).clear();
    }
    for (;;)
    {
      ((EntityManager)localObject1).a();
      return;
      localObject2 = new PushBannerReportLog();
      ((PushBannerReportLog)localObject2).setLog((String)localObject3);
      ((EntityManager)localObject1).a((Entity)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akjx
 * JD-Core Version:    0.7.0.1
 */