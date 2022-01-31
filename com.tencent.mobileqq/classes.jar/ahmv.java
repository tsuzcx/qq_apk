import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;

public class ahmv
  implements Animation.AnimationListener
{
  public ahmv(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.e(this.a).h_(true);
    DanceReadyFilter.e(this.a).a(DanceReadyFilter.c(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.a().a(DanceReadyFilter.a(this.a).a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */