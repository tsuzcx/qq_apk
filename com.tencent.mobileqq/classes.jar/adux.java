import android.os.Message;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import mqq.os.MqqHandler;

public class adux
  extends MqqHandler
{
  public adux(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1981: 
      this.a.finish();
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adux
 * JD-Core Version:    0.7.0.1
 */