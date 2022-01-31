import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.AntiphingToast;

public class akej
  implements Animation.AnimationListener
{
  public akej(AntiphingToast paramAntiphingToast) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AntiphingToast.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akej
 * JD-Core Version:    0.7.0.1
 */