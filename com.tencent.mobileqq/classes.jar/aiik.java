import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import java.lang.ref.WeakReference;

public class aiik
  implements View.OnLongClickListener
{
  public aiik(StructMsgItemButton paramStructMsgItemButton) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      OnLongClickAndTouchListener localOnLongClickAndTouchListener = (OnLongClickAndTouchListener)this.a.a.get();
      if (localOnLongClickAndTouchListener != null) {
        return localOnLongClickAndTouchListener.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiik
 * JD-Core Version:    0.7.0.1
 */