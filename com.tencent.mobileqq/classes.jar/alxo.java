import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class alxo
  implements Comparator<MessageRecord>
{
  public alxo(NearbyGrayTipsManager paramNearbyGrayTipsManager) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.time < paramMessageRecord2.time) {
      return 1;
    }
    if (paramMessageRecord1.time > paramMessageRecord2.time) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxo
 * JD-Core Version:    0.7.0.1
 */