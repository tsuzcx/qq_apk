import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.StartResource;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;

public class ahms
  implements Animation.AnimationListener
{
  public ahms(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a().a(DanceReadyFilter.a(this.a).a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahms
 * JD-Core Version:    0.7.0.1
 */