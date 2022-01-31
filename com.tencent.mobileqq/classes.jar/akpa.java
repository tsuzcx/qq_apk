import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class akpa
  implements Comparator<MessageRecord>
{
  akpa(akow paramakow) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpa
 * JD-Core Version:    0.7.0.1
 */