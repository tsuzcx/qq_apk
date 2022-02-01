import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class ahli
  implements Comparator<MessageRecord>
{
  ahli(ahlf paramahlf) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahli
 * JD-Core Version:    0.7.0.1
 */