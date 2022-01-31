import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class ahyx
  extends AccountObserver
{
  public ahyx(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 == null)
      {
        i = 0;
        QLog.e("Q.history.C2CAllFragment", 2, i);
      }
    }
    else
    {
      paramString1 = this.a.a.obtainMessage(39);
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (int i = 1;; i = 0)
    {
      paramString1.arg1 = i;
      paramString1.arg2 = 0;
      this.a.a.sendMessage(paramString1);
      return;
      i = paramString2.length();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyx
 * JD-Core Version:    0.7.0.1
 */