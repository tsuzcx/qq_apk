import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.AntiphingToast;

public class aksq
  implements Animation.AnimationListener
{
  public aksq(AntiphingToast paramAntiphingToast) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AntiphingToast.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksq
 * JD-Core Version:    0.7.0.1
 */