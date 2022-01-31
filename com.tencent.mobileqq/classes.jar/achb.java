import android.view.MotionEvent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class achb
  implements TopGestureLayout.InterceptTouchEventListener
{
  public achb(ChatFragment paramChatFragment) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.b(paramMotionEvent);
    }
  }
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achb
 * JD-Core Version:    0.7.0.1
 */