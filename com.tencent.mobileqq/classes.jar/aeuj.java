import android.os.Message;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import mqq.os.MqqHandler;

public class aeuj
  extends MqqHandler
{
  public aeuj(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 107) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeuj
 * JD-Core Version:    0.7.0.1
 */