import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

class ajzs
  extends GestureDetector.SimpleOnGestureListener
{
  ajzs(ajzr paramajzr) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ajzr.a(this.a) != null)
    {
      ajzr.a(this.a).onClick(ajzr.a(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzs
 * JD-Core Version:    0.7.0.1
 */