import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aecm
  extends Handler
{
  aecm(aecl paramaecl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == aecl.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecm
 * JD-Core Version:    0.7.0.1
 */