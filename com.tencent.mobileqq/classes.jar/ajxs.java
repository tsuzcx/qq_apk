import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ajxs
  extends aoec
{
  public ajxs(Conversation paramConversation) {}
  
  public void a(List<String> paramList)
  {
    aoxz localaoxz;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localaoxz = this.a.a.getRecentUserProxy();
      if (localaoxz != null) {
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
        RecentUser localRecentUser = (RecentUser)localaoxz.findRecentUserByUin((String)paramList.next(), 0);
        if (localRecentUser != null) {
          localaoxz.delRecentUser(localRecentUser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxs
 * JD-Core Version:    0.7.0.1
 */