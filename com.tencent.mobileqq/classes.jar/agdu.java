import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class agdu
  implements ValueAnimator.AnimatorUpdateListener
{
  agdu(agdt paramagdt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (agdt.a(this.a) != null) {
      agdt.a(this.a).setAlpha((float)d);
    }
    if (agdt.a(this.a) != null) {
      agdt.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdu
 * JD-Core Version:    0.7.0.1
 */