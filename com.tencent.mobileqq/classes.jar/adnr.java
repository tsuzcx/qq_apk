import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.activity.PortraitImageview;

public class adnr
  extends adnt
{
  public adnr(PortraitImageview paramPortraitImageview) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.isInProgress())) {
      try
      {
        float f1 = this.a.a();
        float f2 = paramScaleGestureDetector.getScaleFactor();
        f1 = Math.min(this.a.b(), Math.max(f1 * f2, 0.1F));
        this.a.a(f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        this.a.invalidate();
        return true;
      }
      catch (IllegalArgumentException paramScaleGestureDetector)
      {
        paramScaleGestureDetector.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnr
 * JD-Core Version:    0.7.0.1
 */