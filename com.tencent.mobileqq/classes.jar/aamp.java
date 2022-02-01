import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class aamp
  implements Animation.AnimationListener
{
  aamp(aamn paramaamn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (aamn.a(this.a) != null)
    {
      aamn.a(this.a).clearAnimation();
      aamn.a(this.a).startAnimation(aamn.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamp
 * JD-Core Version:    0.7.0.1
 */