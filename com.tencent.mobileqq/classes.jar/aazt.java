import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class aazt
  implements ViewTreeObserver.OnPreDrawListener
{
  aazt(aazq paramaazq) {}
  
  public boolean onPreDraw()
  {
    aazq.a(this.a).start();
    aazq.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazt
 * JD-Core Version:    0.7.0.1
 */