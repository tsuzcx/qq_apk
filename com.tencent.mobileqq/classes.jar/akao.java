import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class akao
  implements Comparator<MessageRecord>
{
  akao(akak paramakak) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akao
 * JD-Core Version:    0.7.0.1
 */