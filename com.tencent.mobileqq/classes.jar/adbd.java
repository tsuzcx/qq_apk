import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class adbd
  implements ValueAnimator.AnimatorUpdateListener
{
  adbd(adbc paramadbc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (adbc.a(this.a) != null) {
      adbc.a(this.a).setAlpha((float)d);
    }
    if (adbc.a(this.a) != null) {
      adbc.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adbd
 * JD-Core Version:    0.7.0.1
 */