import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView;

public class abbo
  implements ValueAnimator.AnimatorUpdateListener
{
  public abbo(ARMapSplashBgView paramARMapSplashBgView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (ARMapSplashBgView.b(this.a) != null)
    {
      ARMapSplashBgView.b(this.a).setPivotY(ARMapSplashBgView.b(this.a).getHeight() * 0.7F);
      ARMapSplashBgView.b(this.a).setRotation(paramValueAnimator.floatValue() * ARMapSplashBgView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbo
 * JD-Core Version:    0.7.0.1
 */