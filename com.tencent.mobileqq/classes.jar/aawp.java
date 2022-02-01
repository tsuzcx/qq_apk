import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class aawp
  implements Animation.AnimationListener
{
  aawp(aawn paramaawn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (aawn.a(this.a) != null)
    {
      aawn.a(this.a).clearAnimation();
      aawn.a(this.a).startAnimation(aawn.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawp
 * JD-Core Version:    0.7.0.1
 */