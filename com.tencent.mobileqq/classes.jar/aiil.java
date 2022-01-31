import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import java.lang.ref.WeakReference;

public class aiil
  implements View.OnTouchListener
{
  public aiil(StructMsgItemButton paramStructMsgItemButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      OnLongClickAndTouchListener localOnLongClickAndTouchListener = (OnLongClickAndTouchListener)this.a.a.get();
      if (localOnLongClickAndTouchListener != null) {
        return localOnLongClickAndTouchListener.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiil
 * JD-Core Version:    0.7.0.1
 */