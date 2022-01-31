import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView;

public class abbn
  implements ValueAnimator.AnimatorUpdateListener
{
  public abbn(ARMapSplashBgView paramARMapSplashBgView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (ARMapSplashBgView.b(this.a) != null) {
      ARMapSplashBgView.b(this.a).setTranslationY(paramValueAnimator.floatValue() * ARMapSplashBgView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbn
 * JD-Core Version:    0.7.0.1
 */