import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class afgt
  implements ValueAnimator.AnimatorUpdateListener
{
  afgt(afgs paramafgs) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (afgs.a(this.a) != null) {
      afgs.a(this.a).setAlpha((float)d);
    }
    if (afgs.a(this.a) != null) {
      afgs.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgt
 * JD-Core Version:    0.7.0.1
 */