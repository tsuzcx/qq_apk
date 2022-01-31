import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatPanel;

public class aczw
  implements ArkAppView.Callback
{
  public aczw(FlashChatPanel paramFlashChatPanel, MessageForArkFlashChat paramMessageForArkFlashChat1, MessageForArkFlashChat paramMessageForArkFlashChat2) {}
  
  public void a()
  {
    ArkDispatchTask.getInstance().post(new aczx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aczw
 * JD-Core Version:    0.7.0.1
 */