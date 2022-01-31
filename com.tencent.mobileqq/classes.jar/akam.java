import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class akam
  implements Comparator<MessageRecord>
{
  akam(akak paramakak) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akam
 * JD-Core Version:    0.7.0.1
 */