import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;

public class aehz
  implements View.OnTouchListener
{
  public aehz(Conversation paramConversation) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("statusTitle onTouch event :").append(paramMotionEvent.toString()).append(", mGestureDetector is null ");
      if (this.a.a == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.recent", 2, bool);
      if (this.a.a != null) {
        this.a.a.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehz
 * JD-Core Version:    0.7.0.1
 */