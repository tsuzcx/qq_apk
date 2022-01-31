import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;
import java.util.List;

public class aifl
  implements Animation.AnimationListener
{
  public aifl(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (DanceReadyFilter.a(this.a) > 0)
    {
      DanceReadyFilter.e(this.a).a((String)DanceReadyFilter.a(this.a).a.a.get(DanceReadyFilter.a(this.a) - 1));
      if (DanceReadyFilter.c(this.a) != null)
      {
        DanceReadyFilter.c(this.a).setStartOffset(300L);
        DanceReadyFilter.e(this.a).e();
        DanceReadyFilter.e(this.a).a(DanceReadyFilter.c(this.a));
      }
      return;
    }
    DanceReadyFilter.e(this.a).f_(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    DanceReadyFilter.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifl
 * JD-Core Version:    0.7.0.1
 */