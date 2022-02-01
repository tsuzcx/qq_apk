import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class adav
  implements Comparator<MessageRecord>
{
  public adav(QQMessageFacade paramQQMessageFacade) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adav
 * JD-Core Version:    0.7.0.1
 */