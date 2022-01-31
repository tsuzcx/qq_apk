import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout.CaptureButtonListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aalt
  extends Handler
{
  public aalt(ARCardCamereButtonLayout paramARCardCamereButtonLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCamereButtonLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.a.a.get());
    }
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            ARCardCamereButtonLayout.c(this.a);
            return;
          } while (ARCardCamereButtonLayout.a(this.a) == null);
          ARCardCamereButtonLayout.a(this.a).b();
          return;
        } while (!this.a.a.get());
        if (ARCardCamereButtonLayout.a(this.a) != null) {
          ARCardCamereButtonLayout.a(this.a).c();
        }
        this.a.a.set(false);
        ARCardCamereButtonLayout.d(this.a);
        return;
        if (ARCardCamereButtonLayout.a(this.a) != null) {
          ARCardCamereButtonLayout.a(this.a).a();
        }
        ARCardCamereButtonLayout.d(this.a);
        return;
      } while (!this.a.a.get());
      ARCardCamereButtonLayout.e(this.a);
      ARCardCamereButtonLayout.a(this.a).sendEmptyMessageDelayed(5, 50L);
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalt
 * JD-Core Version:    0.7.0.1
 */