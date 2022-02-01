import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class aijq
  implements Animation.AnimationListener
{
  aijq(aijp paramaijp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.p != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.a, 2130772234);
      paramAnimation.setAnimationListener(this);
      this.a.a.p.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijq
 * JD-Core Version:    0.7.0.1
 */