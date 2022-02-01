import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class agax
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public agax(VisitorsActivity paramVisitorsActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int[] arrayOfInt = new int[2];
    this.a.b.getLocationInWindow(arrayOfInt);
    this.a.i = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agax
 * JD-Core Version:    0.7.0.1
 */