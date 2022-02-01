import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class agod
  extends Handler
{
  agod(agoc paramagoc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.obj == null)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 4: 
        agoc.a(this.a);
        return;
      }
      agoc.a(this.a, true);
      return;
    }
    WeakReference localWeakReference = (WeakReference)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      agoc.a(this.a, localWeakReference);
      return;
    case 2: 
      agoc.b(this.a, localWeakReference);
      return;
    }
    agoc.c(this.a, localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agod
 * JD-Core Version:    0.7.0.1
 */