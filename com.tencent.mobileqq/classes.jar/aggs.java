import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class aggs
  implements Animation.AnimationListener
{
  aggs(aggq paramaggq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (aggq.a(this.a) != null) {
      aggq.a(this.a).setVisibility(8);
    }
    if (aggq.a(this.a) != null) {
      aggq.a(this.a).c();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggs
 * JD-Core Version:    0.7.0.1
 */