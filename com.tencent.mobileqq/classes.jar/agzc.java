import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class agzc
  extends Handler
{
  agzc(agzb paramagzb, Looper paramLooper)
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
        agzb.a(this.a);
        return;
      }
      agzb.a(this.a, true);
      return;
    }
    WeakReference localWeakReference = (WeakReference)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      agzb.a(this.a, localWeakReference);
      return;
    case 2: 
      agzb.b(this.a, localWeakReference);
      return;
    }
    agzb.c(this.a, localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzc
 * JD-Core Version:    0.7.0.1
 */