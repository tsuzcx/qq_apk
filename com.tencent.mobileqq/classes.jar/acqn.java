import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class acqn
  implements ValueAnimator.AnimatorUpdateListener
{
  acqn(acqm paramacqm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (acqm.a(this.a) != null) {
      acqm.a(this.a).setAlpha((float)d);
    }
    if (acqm.a(this.a) != null) {
      acqm.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acqn
 * JD-Core Version:    0.7.0.1
 */