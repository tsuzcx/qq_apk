import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class afja
  implements Animation.AnimationListener
{
  afja(afiz paramafiz) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.a != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.mContext, 2130772232);
      paramAnimation.setAnimationListener(this);
      this.a.a.a.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */