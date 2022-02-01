import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class agqt
  extends Handler
{
  agqt(agqs paramagqs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == agqs.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqt
 * JD-Core Version:    0.7.0.1
 */