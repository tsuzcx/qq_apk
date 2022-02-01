import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ahuf
  extends Handler
{
  ahuf(ahue paramahue, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ahue.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuf
 * JD-Core Version:    0.7.0.1
 */