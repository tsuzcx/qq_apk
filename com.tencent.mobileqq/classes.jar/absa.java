import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class absa
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     absa
 * JD-Core Version:    0.7.0.1
 */