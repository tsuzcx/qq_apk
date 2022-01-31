import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class adbg
  implements ValueAnimator.AnimatorUpdateListener
{
  adbg(adbf paramadbf) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (adbf.a(this.a) != null) {
      adbf.a(this.a).setAlpha((float)d);
    }
    if (adbf.a(this.a) != null) {
      adbf.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adbg
 * JD-Core Version:    0.7.0.1
 */