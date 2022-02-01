import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class abdg
  extends Handler
{
  abdg(abdf paramabdf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      abdf.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abdg
 * JD-Core Version:    0.7.0.1
 */