import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class alkb
  extends Handler
{
  public alkb(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = (Bitmap)paramMessage.obj;
      } while (paramMessage == null);
      this.a.a.a("", "", paramMessage, true);
      return;
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    this.a.a.a("", paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alkb
 * JD-Core Version:    0.7.0.1
 */