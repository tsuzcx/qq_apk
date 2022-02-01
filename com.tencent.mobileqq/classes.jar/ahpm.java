import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ahpm
  implements Animation.AnimationListener
{
  ahpm(ahpl paramahpl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ahpl.a(this.a) != null) {
      ahpl.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpm
 * JD-Core Version:    0.7.0.1
 */