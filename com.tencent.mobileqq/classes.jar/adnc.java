import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

class adnc
  implements View.OnClickListener
{
  adnc(admz paramadmz) {}
  
  public void onClick(View paramView)
  {
    paramView = (MessageForArkFlashChat)paramView.getTag();
    apyq localapyq;
    String str1;
    if (paramView != null)
    {
      localapyq = ((FlashChatManager)this.a.a.getManager(217)).a;
      str1 = localapyq.c;
      String str2 = localapyq.f;
      String str3 = localapyq.g;
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "mSourceOnClickListener clickAppMsg url = " + str1 + ", actionData = " + str2 + ", actionDataA = " + str3);
      }
      if (!this.a.a(str1, str2, str3)) {
        break label116;
      }
    }
    label116:
    while (!this.a.a(str1, localapyq.b, paramView)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnc
 * JD-Core Version:    0.7.0.1
 */