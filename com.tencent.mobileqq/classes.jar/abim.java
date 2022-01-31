import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView;

public class abim
  implements ValueAnimator.AnimatorUpdateListener
{
  public abim(ARMapSplashBgView paramARMapSplashBgView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (ARMapSplashBgView.a(this.a) != null) {
      ARMapSplashBgView.a(this.a).setTranslationY(paramValueAnimator.floatValue() * ARMapSplashBgView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abim
 * JD-Core Version:    0.7.0.1
 */