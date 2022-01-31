import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class akbd
  implements Comparator<MessageRecord>
{
  akbd(akbc paramakbc) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbd
 * JD-Core Version:    0.7.0.1
 */