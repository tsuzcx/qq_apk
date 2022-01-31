import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class agpb
  implements Animation.AnimationListener
{
  agpb(agot paramagot) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.W = false;
    this.a.s = 0;
    this.a.X = false;
    this.a.ag = false;
    this.a.af = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(this.a.o, agot.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpb
 * JD-Core Version:    0.7.0.1
 */