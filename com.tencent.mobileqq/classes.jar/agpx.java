import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class agpx
  implements Animation.AnimationListener
{
  agpx(agpw paramagpw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.q != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.a, 2130772225);
      paramAnimation.setAnimationListener(this);
      this.a.a.q.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpx
 * JD-Core Version:    0.7.0.1
 */