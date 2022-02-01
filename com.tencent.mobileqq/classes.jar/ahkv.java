import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ahkv
  extends Handler
{
  ahkv(ahku paramahku, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ahku.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkv
 * JD-Core Version:    0.7.0.1
 */