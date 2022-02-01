import com.tencent.mobileqq.data.MessageForArkApp;
import java.util.Comparator;
import org.json.JSONObject;

class agjn
  implements Comparator<MessageForArkApp>
{
  agjn(agjm paramagjm) {}
  
  public int a(MessageForArkApp paramMessageForArkApp1, MessageForArkApp paramMessageForArkApp2)
  {
    int i = 0;
    try
    {
      long l1 = agjm.a(paramMessageForArkApp1).optLong("time");
      long l2 = agjm.a(paramMessageForArkApp2).optLong("time");
      if (l1 < l2) {
        i = 1;
      }
      while (l1 == l2) {
        return i;
      }
      return -1;
    }
    catch (Throwable paramMessageForArkApp1) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjn
 * JD-Core Version:    0.7.0.1
 */