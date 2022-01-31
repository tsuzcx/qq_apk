import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.2;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.3;

public class akra
  extends Handler
{
  public akra(akqy paramakqy, Looper paramLooper)
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
      akwj.a().a(new ARCamera.ARCameraHandler.1(this));
      removeMessages(100);
      sendEmptyMessageDelayed(100, 3000L);
      return;
    case 101: 
      akwj.a().a(new ARCamera.ARCameraHandler.2(this));
      return;
    }
    akwj.a().a(new ARCamera.ARCameraHandler.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akra
 * JD-Core Version:    0.7.0.1
 */