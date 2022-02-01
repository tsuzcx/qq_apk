import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aadp
  implements View.OnTouchListener
{
  aadp(aadj paramaadj) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      aadj.a(this.a, 0);
    }
    if (aadj.a(this.a) != null) {
      aadj.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadp
 * JD-Core Version:    0.7.0.1
 */