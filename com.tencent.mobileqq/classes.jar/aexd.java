import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class aexd
  implements aiyx
{
  public aexd(QQLSActivity paramQQLSActivity) {}
  
  public void an_() {}
  
  public void b() {}
  
  public void j_(int paramInt)
  {
    if ((paramInt == 0) && (this.a.a.a().size() > 0))
    {
      Iterator localIterator = this.a.a.a().iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData instanceof RecentItemNewFriendMsgData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "Need to delete RecentItemNewFriendMsgData");
          }
          this.a.a.a().remove(localRecentBaseData);
          this.a.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexd
 * JD-Core Version:    0.7.0.1
 */