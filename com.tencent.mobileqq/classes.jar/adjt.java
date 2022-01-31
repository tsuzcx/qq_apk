import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatPanel;

public class adjt
  implements ArkAppView.Callback
{
  public adjt(FlashChatPanel paramFlashChatPanel, MessageForArkFlashChat paramMessageForArkFlashChat1, MessageForArkFlashChat paramMessageForArkFlashChat2) {}
  
  public void a()
  {
    ArkDispatchTask.getInstance().post(new adju(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjt
 * JD-Core Version:    0.7.0.1
 */