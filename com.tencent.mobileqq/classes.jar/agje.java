import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import java.lang.ref.WeakReference;

public class agje
  extends Handler
{
  private WeakReference a;
  
  public agje(ARTipsManager paramARTipsManager)
  {
    this.a = new WeakReference(paramARTipsManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ARTipsManager localARTipsManager = (ARTipsManager)this.a.get();
    if (localARTipsManager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      ARTipsManager.a(localARTipsManager, (agjf)paramMessage.obj);
      return;
    }
    ARTipsManager.a(localARTipsManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agje
 * JD-Core Version:    0.7.0.1
 */