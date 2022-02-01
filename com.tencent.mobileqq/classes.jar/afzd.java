import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class afzd
  implements View.OnTouchListener
{
  afzd(afzc paramafzc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getTag(2131362349);
    if (!(paramView instanceof GestureDetector)) {
      return false;
    }
    paramView = (GestureDetector)paramView;
    paramView.setIsLongpressEnabled(true);
    paramView.onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzd
 * JD-Core Version:    0.7.0.1
 */