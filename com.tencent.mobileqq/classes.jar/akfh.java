import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import java.util.Comparator;

public class akfh
  implements Comparator<akfc>
{
  public akfh(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public int a(akfc paramakfc1, akfc paramakfc2)
  {
    return paramakfc1.f.compareToIgnoreCase(paramakfc2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfh
 * JD-Core Version:    0.7.0.1
 */