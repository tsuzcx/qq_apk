import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter;

public class aibb
  implements Animation.AnimationListener
{
  public aibb(DanceScoreFilter paramDanceScoreFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceScoreFilter.a(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aibb
 * JD-Core Version:    0.7.0.1
 */