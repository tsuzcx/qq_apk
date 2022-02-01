import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.widget.XListView;

public class ajrr
  extends Handler
{
  public ajrr(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != 1) || (ChatHistoryTroopFileFragment.a(this.a) == null)) {}
    for (;;)
    {
      return;
      int i = ChatHistoryTroopFileFragment.a(this.a).getFirstVisiblePosition();
      while (i <= ChatHistoryTroopFileFragment.a(this.a).getLastVisiblePosition())
      {
        paramMessage = ChatHistoryTroopFileFragment.a(this.a).getChildAt(i);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.getTag();
          if ((paramMessage != null) && ((paramMessage instanceof bewa))) {
            ((bewa)paramMessage).a(this.a.a, ChatHistoryTroopFileFragment.a(this.a));
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrr
 * JD-Core Version:    0.7.0.1
 */