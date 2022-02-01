import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aahq
  implements View.OnTouchListener
{
  aahq(aahk paramaahk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      aahk.a(this.a, 0);
    }
    if (aahk.a(this.a) != null) {
      aahk.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahq
 * JD-Core Version:    0.7.0.1
 */