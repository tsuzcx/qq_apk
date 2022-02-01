import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class afxy
  implements ValueAnimator.AnimatorUpdateListener
{
  afxy(afxx paramafxx) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (afxx.a(this.a) != null) {
      afxx.a(this.a).setAlpha((float)d);
    }
    if (afxx.a(this.a) != null) {
      afxx.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxy
 * JD-Core Version:    0.7.0.1
 */