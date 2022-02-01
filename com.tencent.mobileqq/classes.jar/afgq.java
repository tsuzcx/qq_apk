import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class afgq
  implements ValueAnimator.AnimatorUpdateListener
{
  afgq(afgp paramafgp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (afgp.a(this.a) != null) {
      afgp.a(this.a).setAlpha((float)d);
    }
    if (afgp.a(this.a) != null) {
      afgp.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgq
 * JD-Core Version:    0.7.0.1
 */