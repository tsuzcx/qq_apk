import android.os.Message;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import mqq.os.MqqHandler;

public class adhv
  extends MqqHandler
{
  public adhv(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2014: 
      this.a.finish();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhv
 * JD-Core Version:    0.7.0.1
 */