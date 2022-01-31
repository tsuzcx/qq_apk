import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView;

public class abin
  implements ValueAnimator.AnimatorUpdateListener
{
  public abin(ARMapSplashBgView paramARMapSplashBgView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (ARMapSplashBgView.a(this.a) != null)
    {
      ARMapSplashBgView.a(this.a).setPivotY(ARMapSplashBgView.a(this.a).getHeight() * 0.7F);
      ARMapSplashBgView.a(this.a).setRotation(paramValueAnimator.floatValue() * ARMapSplashBgView.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abin
 * JD-Core Version:    0.7.0.1
 */