import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aggr
  implements Animation.AnimationListener
{
  aggr(aggq paramaggq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (aggq.a(this.a) != null) {
      aggq.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggr
 * JD-Core Version:    0.7.0.1
 */