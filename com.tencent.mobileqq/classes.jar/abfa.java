import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

public class abfa
  extends MessageObserver
{
  public abfa(ArkTipsManager paramArkTipsManager) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if ((ArkTipsManager.a(this.a) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == ArkTipsManager.a(this.a).b)) {
          this.a.a(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfa
 * JD-Core Version:    0.7.0.1
 */