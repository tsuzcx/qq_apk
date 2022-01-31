import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;

public class aifk
  implements Animation.AnimationListener
{
  public aifk(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    switch (DanceReadyFilter.a(this.a))
    {
    }
    for (;;)
    {
      DanceReadyFilter.b(this.a);
      if (DanceReadyFilter.a(this.a) == 0)
      {
        DanceReadyFilter.d(this.a).e();
        DanceReadyFilter.d(this.a).a(DanceReadyFilter.b(this.a));
      }
      return;
      this.a.a.a().a(DanceReadyFilter.a(this.a).a.e);
      continue;
      this.a.a.a().a(DanceReadyFilter.a(this.a).a.d);
      continue;
      this.a.a.a().a(DanceReadyFilter.a(this.a).a.c);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifk
 * JD-Core Version:    0.7.0.1
 */