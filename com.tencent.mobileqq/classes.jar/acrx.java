import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class acrx
  extends amdd
{
  public acrx(Conversation paramConversation) {}
  
  public void a(List<String> paramList)
  {
    amnz localamnz;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localamnz = this.a.a.a();
      if (localamnz != null) {
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
        RecentUser localRecentUser = localamnz.a((String)paramList.next(), 0);
        if (localRecentUser != null) {
          localamnz.b(localRecentUser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrx
 * JD-Core Version:    0.7.0.1
 */