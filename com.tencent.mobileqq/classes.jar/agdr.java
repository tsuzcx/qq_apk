import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class agdr
  implements ValueAnimator.AnimatorUpdateListener
{
  agdr(agdq paramagdq) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (agdq.a(this.a) != null) {
      agdq.a(this.a).setAlpha((float)d);
    }
    if (agdq.a(this.a) != null) {
      agdq.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdr
 * JD-Core Version:    0.7.0.1
 */