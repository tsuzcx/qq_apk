import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class abas
  implements Animation.AnimationListener
{
  abas(abaq paramabaq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (abaq.a(this.a) != null)
    {
      abaq.a(this.a).clearAnimation();
      abaq.a(this.a).startAnimation(abaq.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abas
 * JD-Core Version:    0.7.0.1
 */