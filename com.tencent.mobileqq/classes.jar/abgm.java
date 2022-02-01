import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class abgm
  extends Handler
{
  abgm(abgj paramabgj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bisp)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bisp)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abgm
 * JD-Core Version:    0.7.0.1
 */