import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class abcj
  extends Handler
{
  abcj(abcg paramabcg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bhru)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bhru)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcj
 * JD-Core Version:    0.7.0.1
 */