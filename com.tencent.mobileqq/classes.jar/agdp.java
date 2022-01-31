import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class agdp
  extends Handler
{
  agdp(agdo paramagdo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == agdo.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdp
 * JD-Core Version:    0.7.0.1
 */