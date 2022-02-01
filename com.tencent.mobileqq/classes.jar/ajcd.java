import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ajcd
  extends anbn
{
  public ajcd(Conversation paramConversation) {}
  
  public void a(List<String> paramList)
  {
    anuz localanuz;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localanuz = this.a.a.getRecentUserProxy();
      if (localanuz != null) {
        break label37;
      }
      QLog.d("Q.recent", 1, "onBatchDelete, proxy == null");
    }
    for (;;)
    {
      return;
      label37:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)localanuz.findRecentUserByUin((String)paramList.next(), 0);
        if (localRecentUser != null) {
          localanuz.delRecentUser(localRecentUser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcd
 * JD-Core Version:    0.7.0.1
 */