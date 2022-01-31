import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;

public class ajgy
  extends TouchDelegate
{
  public ajgy(DragTextView paramDragTextView, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.getVisibility() != 0) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool = super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.setLocation(f1, f2);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgy
 * JD-Core Version:    0.7.0.1
 */