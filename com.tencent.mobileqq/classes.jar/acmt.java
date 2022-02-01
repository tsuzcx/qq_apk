import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class acmt
  implements Comparator<MessageRecord>
{
  acmt(acmp paramacmp) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmt
 * JD-Core Version:    0.7.0.1
 */