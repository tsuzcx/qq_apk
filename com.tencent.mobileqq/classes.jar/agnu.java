import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class agnu
  implements ValueAnimator.AnimatorUpdateListener
{
  agnu(agnt paramagnt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (agnt.a(this.a) != null) {
      agnt.a(this.a).setAlpha((float)d);
    }
    if (agnt.a(this.a) != null) {
      agnt.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnu
 * JD-Core Version:    0.7.0.1
 */