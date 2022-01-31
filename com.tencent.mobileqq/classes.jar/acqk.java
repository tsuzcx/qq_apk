import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class acqk
  implements ValueAnimator.AnimatorUpdateListener
{
  acqk(acqj paramacqj) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (acqj.a(this.a) != null) {
      acqj.a(this.a).setAlpha((float)d);
    }
    if (acqj.a(this.a) != null) {
      acqj.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acqk
 * JD-Core Version:    0.7.0.1
 */