import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;

public class aifo
  implements Animation.AnimationListener
{
  public aifo(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.d(this.a).f_(false);
    DanceReadyFilter.f(this.a).a(DanceReadyFilter.d(this.a));
    DanceReadyFilter.f(this.a).f_(true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifo
 * JD-Core Version:    0.7.0.1
 */