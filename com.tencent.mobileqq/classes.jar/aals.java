import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class aals
  implements ViewTreeObserver.OnPreDrawListener
{
  aals(aalp paramaalp) {}
  
  public boolean onPreDraw()
  {
    aalp.a(this.a).start();
    aalp.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aals
 * JD-Core Version:    0.7.0.1
 */