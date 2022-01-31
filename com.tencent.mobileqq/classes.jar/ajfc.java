import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import java.util.Comparator;

public class ajfc
  implements Comparator
{
  public ajfc(TroopMessageProcessor paramTroopMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfc
 * JD-Core Version:    0.7.0.1
 */