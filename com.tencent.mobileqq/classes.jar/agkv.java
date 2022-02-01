import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class agkv
  extends Handler
{
  agkv(agkt paramagkt, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      agkt.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */