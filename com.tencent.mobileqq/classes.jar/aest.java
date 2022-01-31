import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class aest
  implements ValueAnimator.AnimatorUpdateListener
{
  aest(aess paramaess) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (aess.a(this.a) != null) {
      aess.a(this.a).setAlpha((float)d);
    }
    if (aess.a(this.a) != null) {
      aess.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aest
 * JD-Core Version:    0.7.0.1
 */