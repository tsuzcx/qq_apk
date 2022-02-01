import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class afxv
  implements ValueAnimator.AnimatorUpdateListener
{
  afxv(afxu paramafxu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (afxu.a(this.a) != null) {
      afxu.a(this.a).setAlpha((float)d);
    }
    if (afxu.a(this.a) != null) {
      afxu.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxv
 * JD-Core Version:    0.7.0.1
 */