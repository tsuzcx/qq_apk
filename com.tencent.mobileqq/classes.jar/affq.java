import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class affq
  implements affa, Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public affq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private ChatMessage a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqo.a();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("vip_ptt.helper", 1, "SHOW_FIRST:" + localChatMessage.msgtype);
      }
      if (localChatMessage.msgtype != -2002) {
        break label123;
      }
      QLog.e("vip_ptt.helper", 1, "SHOW_FIRST find the ptt msg");
      i = 1;
    }
    label123:
    for (;;)
    {
      break;
      if (i != 0) {
        return (ChatMessage)localList.get(localList.size() - 1);
      }
      return null;
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    paramString = new aspy(paramChatMessage.frienduin, paramChatMessage.selfuin, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, -5020, 655392, paramChatMessage.time);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      localMessageForUniteGrayTip.shmsgseq = paramChatMessage.shmsgseq;
    }
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    aspz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
    QLog.e("vip_ptt.helper", 1, "It is need add gray msg and insert success");
  }
  
  private boolean a()
  {
    if ((aous.c().a <= 1) && (afxv.d)) {
      return !beat.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_gray_msg", false);
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
    case 5: 
    case 6: 
      do
      {
        return;
        QLog.e("vip_ptt.helper", 1, "SHOW_FIRST_BEGIN");
        return;
      } while (!a());
      QLog.e("vip_ptt.helper", 1, "It is need add gray msg");
      ChatMessage localChatMessage = a();
      if (localChatMessage == null)
      {
        QLog.e("vip_ptt.helper", 1, "It is need add gray msg,but this aio not ptt msg");
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10102, localChatMessage));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10102);
  }
  
  public int[] a()
  {
    return new int[] { 5, 6, 9 };
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = (ChatMessage)paramMessage.obj;
    if (aous.c().a <= 1)
    {
      a(paramMessage, alud.a(2131709103));
      beat.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_gray_msg", true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affq
 * JD-Core Version:    0.7.0.1
 */