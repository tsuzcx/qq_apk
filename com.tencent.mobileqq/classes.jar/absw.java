import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class absw
  implements Comparator<MessageRecord>
{
  absw(absu paramabsu) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absw
 * JD-Core Version:    0.7.0.1
 */