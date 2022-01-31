import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aeco
  extends Handler
{
  aeco(aecn paramaecn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == aecn.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeco
 * JD-Core Version:    0.7.0.1
 */