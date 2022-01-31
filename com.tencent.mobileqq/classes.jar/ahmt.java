import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;

public class ahmt
  implements Animation.AnimationListener
{
  public ahmt(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.f(this.a).h_(false);
    this.a.a.a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmt
 * JD-Core Version:    0.7.0.1
 */