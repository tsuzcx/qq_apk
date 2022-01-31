import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class adje
  implements ScaleGestureDetector.OnScaleGestureListener
{
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adje
 * JD-Core Version:    0.7.0.1
 */