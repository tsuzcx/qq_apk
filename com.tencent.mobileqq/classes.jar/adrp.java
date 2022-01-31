import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class adrp
  extends Handler
{
  adrp(adro paramadro, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == adro.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrp
 * JD-Core Version:    0.7.0.1
 */