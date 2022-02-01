import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class abwm
  implements Comparator<MessageRecord>
{
  abwm(abwi paramabwi) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwm
 * JD-Core Version:    0.7.0.1
 */