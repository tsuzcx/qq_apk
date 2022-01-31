import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ahyq
  implements Handler.Callback
{
  public ahyq(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 6: 
    case 7: 
    case 11: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 22: 
    case 23: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 65537: 
    case 65538: 
    case 65539: 
    case 65540: 
    case 24: 
    case 25: 
    case 27: 
    case 28: 
    case 33: 
    case 14: 
    case 15: 
    case 26: 
    case 34: 
    case 13: 
      do
      {
        return true;
        this.a.g(paramMessage);
        return true;
        this.a.a(paramMessage);
        return true;
        this.a.f(paramMessage);
        return true;
        this.a.e(paramMessage);
        return true;
        this.a.b(paramMessage);
        return true;
        this.a.d(paramMessage);
        return true;
        this.a.c(paramMessage);
        return true;
        ChatHistoryC2CAllFragment.a(this.a);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.C2CAllFragment", 2, "handle_get_roam_msg_auth_mode notify UI");
        }
        if (this.a.jdField_a_of_type_Alxa.f())
        {
          this.a.c(false);
          return true;
        }
        this.a.t();
        return true;
      } while (paramMessage.obj == null);
      ChatHistoryC2CAllFragment localChatHistoryC2CAllFragment = this.a;
      BaseApplication localBaseApplication = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      if (((Boolean)paramMessage.obj).booleanValue() == true) {}
      for (int i = 2131692295;; i = 2131692294)
      {
        localChatHistoryC2CAllFragment.a(localBaseApplication.getString(i));
        return true;
      }
    case 39: 
      ChatHistoryC2CAllFragment.a(this.a, paramMessage);
      return true;
    case 40: 
      ChatHistoryC2CAllFragment.b(this.a, paramMessage);
      return true;
    case 41: 
      ChatHistoryC2CAllFragment.c(this.a, paramMessage);
      return true;
    }
    ChatHistoryC2CAllFragment.d(this.a, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyq
 * JD-Core Version:    0.7.0.1
 */