import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class absy
  implements Comparator<MessageRecord>
{
  absy(absu paramabsu) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absy
 * JD-Core Version:    0.7.0.1
 */