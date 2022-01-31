import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class aemt
  extends GestureDetector.SimpleOnGestureListener
{
  public aemt(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemt
 * JD-Core Version:    0.7.0.1
 */