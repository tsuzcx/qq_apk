import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class aexf
  implements ValueAnimator.AnimatorUpdateListener
{
  aexf(aexe paramaexe) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (aexe.a(this.a) != null) {
      aexe.a(this.a).setAlpha((float)d);
    }
    if (aexe.a(this.a) != null) {
      aexe.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexf
 * JD-Core Version:    0.7.0.1
 */