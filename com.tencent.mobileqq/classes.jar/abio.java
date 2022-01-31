import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView;

public class abio
  implements ValueAnimator.AnimatorUpdateListener
{
  public abio(ARMapSplashBgView paramARMapSplashBgView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (ARMapSplashBgView.b(this.a) != null) {
      ARMapSplashBgView.b(this.a).setTranslationY(paramValueAnimator.floatValue() * ARMapSplashBgView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abio
 * JD-Core Version:    0.7.0.1
 */