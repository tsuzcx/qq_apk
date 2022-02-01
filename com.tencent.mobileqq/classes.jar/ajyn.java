import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.qphone.base.util.QLog;

public class ajyn
  extends GestureDetector.SimpleOnGestureListener
{
  public ajyn(Conversation paramConversation) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, " gestureDetector onDoubleTap");
    }
    Conversation.o(this.a);
    return super.onDoubleTap(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyn
 * JD-Core Version:    0.7.0.1
 */