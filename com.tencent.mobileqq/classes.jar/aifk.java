import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class aifk
  implements View.OnTouchListener
{
  aifk(aifj paramaifj, aife paramaife) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifk
 * JD-Core Version:    0.7.0.1
 */