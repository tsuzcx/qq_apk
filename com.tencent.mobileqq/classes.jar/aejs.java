import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class aejs
  implements Animation.AnimationListener
{
  aejs(aejb paramaejb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.setBackgroundResource(2130842947);
    this.a.a.setBackgroundResource(2130842953);
    this.a.q.setVisibility(8);
    this.a.r.setVisibility(8);
    this.a.o.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.q.setVisibility(0);
    this.a.r.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejs
 * JD-Core Version:    0.7.0.1
 */