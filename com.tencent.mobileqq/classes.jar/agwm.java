import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class agwm
  implements Animation.AnimationListener
{
  agwm(agwl paramagwl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (agwl.a(this.a) != null) {
      agwl.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwm
 * JD-Core Version:    0.7.0.1
 */