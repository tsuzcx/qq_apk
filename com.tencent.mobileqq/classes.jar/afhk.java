import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;

public class afhk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public afhk(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      this.a.b(this.a.e);
      this.a.c(this.a.e);
      View localView = this.a.a.getChildAt(this.a.e);
      if (localView != null)
      {
        this.a.h = localView.getLeft();
        this.a.invalidate();
      }
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afhk
 * JD-Core Version:    0.7.0.1
 */