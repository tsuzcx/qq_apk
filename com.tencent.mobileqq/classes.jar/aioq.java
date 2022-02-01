import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;

public class aioq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aioq(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
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
        if (localView.getMeasuredWidth() == 0)
        {
          this.a.h = (SimpleSlidingIndicator.a(this.a) + (SimpleSlidingIndicator.b(this.a) + SimpleSlidingIndicator.c(this.a)) * this.a.e);
          if (QLog.isColorLevel()) {
            QLog.i("SimpleSlidingIndicator", 2, "onGlobalLayout, x[" + this.a.h + "], size[" + this.a.a.getChildCount() + "], left[" + localView.getLeft() + "], width[" + localView.getMeasuredWidth() + "], pos[" + this.a.e + "], CPlr" + SimpleSlidingIndicator.a(this.a) + "]");
          }
        }
        this.a.invalidate();
      }
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioq
 * JD-Core Version:    0.7.0.1
 */