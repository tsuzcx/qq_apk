import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahap
  implements View.OnClickListener
{
  ahap(aham paramaham) {}
  
  public void onClick(View paramView)
  {
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.getTag();
    auvi localauvi;
    String str1;
    if (localMessageForArkFlashChat != null)
    {
      localauvi = ((FlashChatManager)this.a.a.getManager(217)).a;
      str1 = localauvi.c;
      String str2 = localauvi.f;
      String str3 = localauvi.g;
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
      if (!this.a.a(str1, localauvi.b, localMessageForArkFlashChat)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahap
 * JD-Core Version:    0.7.0.1
 */