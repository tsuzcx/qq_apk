import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter;

public class ahmy
  implements Animation.AnimationListener
{
  public ahmy(DanceScoreFilter paramDanceScoreFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceScoreFilter.a(this.a).h_(true);
    if (DanceScoreFilter.a(this.a) != null) {
      DanceScoreFilter.a(this.a).a(DanceScoreFilter.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmy
 * JD-Core Version:    0.7.0.1
 */