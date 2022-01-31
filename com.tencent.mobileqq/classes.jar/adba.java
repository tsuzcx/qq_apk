import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class adba
  implements ValueAnimator.AnimatorUpdateListener
{
  adba(adaz paramadaz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (adaz.a(this.a) != null) {
      adaz.a(this.a).setAlpha((float)d);
    }
    if (adaz.a(this.a) != null) {
      adaz.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adba
 * JD-Core Version:    0.7.0.1
 */