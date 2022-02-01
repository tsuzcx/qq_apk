import android.os.SystemClock;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qphone.base.util.QLog;

public class ajzp
  implements GestureDetector.OnDoubleTapListener
{
  public ajzp(MainFragment paramMainFragment) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDoubleTap() called with: e = [" + paramMotionEvent + "]");
    }
    MainFragment.a(this.a, SystemClock.uptimeMillis());
    paramMotionEvent = (Conversation)this.a.a(Conversation.class);
    if (paramMotionEvent != null) {}
    for (int i = paramMotionEvent.d;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onDoubleTap() unReadCount = " + i);
      }
      paramMotionEvent = this.a.b();
      if ((paramMotionEvent instanceof Conversation)) {
        ((Conversation)paramMotionEvent).d();
      }
      if (i == 0) {
        MainFragment.d(this.a);
      }
      return false;
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzp
 * JD-Core Version:    0.7.0.1
 */