import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout.CaptureButtonListenerInterceptor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aaer
  implements View.OnTouchListener
{
  public aaer(ARCardCamereButtonLayout paramARCardCamereButtonLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCamereButtonLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.a.a.get() + ", actionUp:" + this.a.b.get() + ", isOver:" + ARCardCamereButtonLayout.a(this.a));
    }
    this.a.a();
    if (ARCardCamereButtonLayout.a(this.a)) {}
    do
    {
      return false;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        return false;
      }
    } while (ARCardCamereButtonLayout.b(this.a));
    if ((ARCardCamereButtonLayout.a(this.a) != null) && (!ARCardCamereButtonLayout.a(this.a).a())) {
      return true;
    }
    this.a.b();
    if ((ARCardCamereButtonLayout.a(this.a) == 3) || (ARCardCamereButtonLayout.a(this.a) == 1)) {
      ARCardCamereButtonLayout.a(this.a).sendEmptyMessageDelayed(1, 100L);
    }
    ARCardCamereButtonLayout.a(this.a, true);
    return true;
    ARCardCamereButtonLayout.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaer
 * JD-Core Version:    0.7.0.1
 */