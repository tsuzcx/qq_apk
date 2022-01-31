import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class aekn
  implements View.OnTouchListener
{
  aekn(aekm paramaekm, aekh paramaekh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekn
 * JD-Core Version:    0.7.0.1
 */