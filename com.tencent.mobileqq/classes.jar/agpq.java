import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agpq
  implements View.OnClickListener
{
  agpq(agpn paramagpn) {}
  
  public void onClick(View paramView)
  {
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.getTag();
    aulx localaulx;
    String str1;
    if (localMessageForArkFlashChat != null)
    {
      localaulx = ((FlashChatManager)this.a.a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a;
      str1 = localaulx.c;
      String str2 = localaulx.f;
      String str3 = localaulx.g;
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "mSourceOnClickListener clickAppMsg url = " + str1 + ", actionData = " + str2 + ", actionDataA = " + str3);
      }
      if (!this.a.a(str1, str2, str3)) {
        break label126;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label126:
      if (!this.a.a(str1, localaulx.b, localMessageForArkFlashChat)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpq
 * JD-Core Version:    0.7.0.1
 */