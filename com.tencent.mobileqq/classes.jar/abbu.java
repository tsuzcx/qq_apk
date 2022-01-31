import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;

public class abbu
  implements ValueAnimator.AnimatorUpdateListener
{
  public abbu(ARMapSplashView paramARMapSplashView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 1000.0F;
    ARMapSplashView.a(this.a).setRotation(SplashBitmapUtils.d(f, ARMapSplashView.a(this.a)));
    ARMapSplashView.a(this.a).setTranslationX(SplashBitmapUtils.a(f, ARMapSplashView.a(this.a)));
    ARMapSplashView.a(this.a).setTranslationY(SplashBitmapUtils.b(f, ARMapSplashView.a(this.a)));
    f = SplashBitmapUtils.c(f, ARMapSplashView.a(this.a));
    ARMapSplashView.a(this.a).setScaleX(f);
    ARMapSplashView.a(this.a).setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbu
 * JD-Core Version:    0.7.0.1
 */