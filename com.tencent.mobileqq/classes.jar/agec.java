import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.qphone.base.util.QLog;

public class agec
  implements Handler.Callback
{
  public agec(ConversationNowController paramConversationNowController) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      QLog.d("ConversationNowController", 1, "preload eve packet list");
      continue;
      QLog.d("ConversationNowController", 1, "report pendant show data");
      try
      {
        this.a.c();
      }
      catch (Exception paramMessage)
      {
        QLog.e("ConversationNowController", 1, "MSG_PENDANT_SHOW_REPORT, exception=", paramMessage);
      }
      continue;
      QLog.d("ConversationNowController", 1, "report saved pendant show");
      try
      {
        this.a.d();
      }
      catch (Exception paramMessage)
      {
        QLog.e("ConversationNowController", 1, "MSG_SAVED_PENDANT_SHOW_REPORT, exception=", paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agec
 * JD-Core Version:    0.7.0.1
 */