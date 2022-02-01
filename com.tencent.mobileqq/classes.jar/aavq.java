import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class aavq
  implements ViewTreeObserver.OnPreDrawListener
{
  aavq(aavn paramaavn) {}
  
  public boolean onPreDraw()
  {
    aavn.a(this.a).start();
    aavn.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aavq
 * JD-Core Version:    0.7.0.1
 */