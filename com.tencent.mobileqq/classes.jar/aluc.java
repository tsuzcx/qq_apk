import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class aluc
  extends akat
{
  aluc(alub paramalub) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((alub.a(this.a) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == alub.a(this.a).b)) {
          this.a.a(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aluc
 * JD-Core Version:    0.7.0.1
 */