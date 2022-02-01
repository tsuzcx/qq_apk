import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aacx
  extends Handler
{
  aacx(aacu paramaacu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bgyr)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bgyr)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacx
 * JD-Core Version:    0.7.0.1
 */