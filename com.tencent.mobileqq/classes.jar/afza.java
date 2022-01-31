import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class afza
  extends Handler
{
  afza(afyz paramafyz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == afyz.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afza
 * JD-Core Version:    0.7.0.1
 */