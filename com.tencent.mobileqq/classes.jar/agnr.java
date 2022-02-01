import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class agnr
  implements ValueAnimator.AnimatorUpdateListener
{
  agnr(agnq paramagnq) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (agnq.a(this.a) != null) {
      agnq.a(this.a).setAlpha((float)d);
    }
    if (agnq.a(this.a) != null) {
      agnq.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnr
 * JD-Core Version:    0.7.0.1
 */