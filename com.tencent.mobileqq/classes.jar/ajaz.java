import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import java.util.ArrayList;
import java.util.Iterator;

public class ajaz
  extends antq
{
  public ajaz(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onAddDiscussionMember(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).b(paramLong);
    }
  }
  
  protected void onChangeDiscussionName(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      long l = Long.parseLong(paramString);
      SystemMsgListView.a(this.a).b(l);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void updateDiscussionInfo(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      if (!(paramObject instanceof ArrayList)) {
        break label76;
      }
    }
    label76:
    for (paramObject = (ArrayList)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            SystemMsgListView.a(this.a).b(((Long)localObject).longValue());
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajaz
 * JD-Core Version:    0.7.0.1
 */