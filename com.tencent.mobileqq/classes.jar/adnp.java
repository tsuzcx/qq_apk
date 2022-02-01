import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class adnp
  implements TopGestureLayout.InterceptTouchEventListener
{
  public adnp(ChatFragment paramChatFragment) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.onDispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnp
 * JD-Core Version:    0.7.0.1
 */