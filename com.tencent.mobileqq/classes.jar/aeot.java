import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class aeot
  implements Animation.AnimationListener
{
  aeot(aeos paramaeos) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.q != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.a, 2130772209);
      paramAnimation.setAnimationListener(this);
      this.a.a.q.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeot
 * JD-Core Version:    0.7.0.1
 */