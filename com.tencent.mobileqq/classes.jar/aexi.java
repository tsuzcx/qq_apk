import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class aexi
  implements ValueAnimator.AnimatorUpdateListener
{
  aexi(aexh paramaexh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (aexh.a(this.a) != null) {
      aexh.a(this.a).setAlpha((float)d);
    }
    if (aexh.a(this.a) != null) {
      aexh.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexi
 * JD-Core Version:    0.7.0.1
 */