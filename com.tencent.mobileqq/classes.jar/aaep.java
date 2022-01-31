import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout;

public class aaep
  implements ValueAnimator.AnimatorUpdateListener
{
  public aaep(ARCardCamereButtonLayout paramARCardCamereButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ARCardCamereButtonLayout.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaep
 * JD-Core Version:    0.7.0.1
 */