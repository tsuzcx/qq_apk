import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Comparator;

public class afgf
  implements Comparator<ChatMessage>
{
  public afgf(QQLSActivity paramQQLSActivity) {}
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1.time == paramChatMessage2.time) {
      return 0;
    }
    if (paramChatMessage1.time > paramChatMessage2.time) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgf
 * JD-Core Version:    0.7.0.1
 */