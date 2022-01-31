import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class adlp
  extends Handler
{
  adlp(adlo paramadlo, Looper paramLooper)
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
        adlo.a(this.a);
        return;
      }
      adlo.a(this.a, true);
      return;
    }
    WeakReference localWeakReference = (WeakReference)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      adlo.a(this.a, localWeakReference);
      return;
    case 2: 
      adlo.b(this.a, localWeakReference);
      return;
    }
    adlo.c(this.a, localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adlp
 * JD-Core Version:    0.7.0.1
 */