import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class agcd
  implements Animation.AnimationListener
{
  agcd(agcb paramagcb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (agcb.a(this.a) != null) {
      agcb.a(this.a).setVisibility(8);
    }
    if (agcb.a(this.a) != null) {
      agcb.a(this.a).c();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcd
 * JD-Core Version:    0.7.0.1
 */