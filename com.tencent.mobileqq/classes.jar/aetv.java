import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;

public class aetv
  extends Handler
{
  public aetv(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 101: 
      this.a.c();
      String str = paramMessage.obj.toString();
      paramMessage = str;
      if (str == null) {
        paramMessage = this.a.getString(2131719806);
      }
      this.a.a(paramMessage, 1);
      return;
    }
    this.a.c();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetv
 * JD-Core Version:    0.7.0.1
 */