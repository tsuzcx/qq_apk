import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;

public class accf
  extends Handler
{
  public accf(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.c();
    String str = paramMessage.obj.toString();
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131721199);
    }
    this.a.a(paramMessage, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accf
 * JD-Core Version:    0.7.0.1
 */