import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ahja
  implements Animation.AnimationListener
{
  ahja(ahiu paramahiu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.e = false;
    this.a.c = 0;
    this.a.f = false;
    this.a.o = false;
    this.a.n = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(this.a.a, ahiu.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahja
 * JD-Core Version:    0.7.0.1
 */