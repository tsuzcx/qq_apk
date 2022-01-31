import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;

public class aaxf
  extends GestureDetector.SimpleOnGestureListener
{
  public aaxf(Conversation paramConversation) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, " gestureDetector onDoubleTap");
    }
    Conversation.i(this.a);
    return super.onDoubleTap(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxf
 * JD-Core Version:    0.7.0.1
 */