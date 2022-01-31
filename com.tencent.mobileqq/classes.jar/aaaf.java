import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.AREngine;

public class aaaf
  extends Handler
{
  public aaaf(ARCamera paramARCamera, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      AREngine.c(new aaag(this));
      removeMessages(100);
      sendEmptyMessageDelayed(100, 3000L);
      return;
    case 101: 
      AREngine.c(new aaah(this));
      return;
    }
    AREngine.c(new aaai(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaaf
 * JD-Core Version:    0.7.0.1
 */