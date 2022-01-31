import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class akqo
  implements Comparator<MessageRecord>
{
  public akqo(QQMessageFacade paramQQMessageFacade) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqo
 * JD-Core Version:    0.7.0.1
 */