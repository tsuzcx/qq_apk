import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class aikr
  implements Comparator<MessageRecord>
{
  aikr(aikq paramaikq) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.shmsgseq < paramMessageRecord2.shmsgseq) {
      return 1;
    }
    if (paramMessageRecord1.shmsgseq > paramMessageRecord2.shmsgseq) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikr
 * JD-Core Version:    0.7.0.1
 */