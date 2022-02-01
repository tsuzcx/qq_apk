import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

class aklb
  extends GestureDetector.SimpleOnGestureListener
{
  aklb(akla paramakla) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (akla.a(this.a) != null)
    {
      akla.a(this.a).onClick(akla.a(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklb
 * JD-Core Version:    0.7.0.1
 */