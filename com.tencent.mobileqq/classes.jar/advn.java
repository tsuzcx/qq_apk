import android.os.Message;
import com.tencent.mobileqq.activity.SubLoginActivity;
import mqq.os.MqqHandler;

public class advn
  extends MqqHandler
{
  public advn(SubLoginActivity paramSubLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1982: 
      this.a.finish();
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advn
 * JD-Core Version:    0.7.0.1
 */