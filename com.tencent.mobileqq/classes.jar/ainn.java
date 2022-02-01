import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ainn
  implements Animation.AnimationListener
{
  ainn(ainh paramainh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.V = false;
    this.a.s = 0;
    this.a.W = false;
    this.a.af = false;
    this.a.ae = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(this.a.n, ainh.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainn
 * JD-Core Version:    0.7.0.1
 */