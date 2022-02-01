import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

class ajja
  extends GestureDetector.SimpleOnGestureListener
{
  ajja(ajiz paramajiz) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ajiz.a(this.a) != null)
    {
      ajiz.a(this.a).onClick(ajiz.a(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajja
 * JD-Core Version:    0.7.0.1
 */