import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class aesq
  implements ValueAnimator.AnimatorUpdateListener
{
  aesq(aesp paramaesp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (aesp.a(this.a) != null) {
      aesp.a(this.a).setAlpha((float)d);
    }
    if (aesp.a(this.a) != null) {
      aesp.a(this.a).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesq
 * JD-Core Version:    0.7.0.1
 */