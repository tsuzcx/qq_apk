import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ShareResource;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter.GamePlayOutData;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter;
import java.util.List;

public class aifu
  implements Animation.AnimationListener
{
  public aifu(DanceScoreFilter paramDanceScoreFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceScoreFilter.a(this.a, true);
    DanceScoreFilter.a(this.a, SystemClock.elapsedRealtime());
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    int i = ResourceManager.a().a().size() * 50;
    int j = this.a.a.a.a;
    if (j < i * 0.2F)
    {
      DanceScoreFilter.b(this.a).a(DanceScoreFilter.a(this.a).a.d);
      DanceScoreFilter.a(this.a, "C");
      return;
    }
    if (j < i * 0.3F)
    {
      DanceScoreFilter.b(this.a).a(DanceScoreFilter.a(this.a).a.c);
      DanceScoreFilter.a(this.a, "B");
      return;
    }
    if (j < i * 0.4F)
    {
      DanceScoreFilter.b(this.a).a(DanceScoreFilter.a(this.a).a.b);
      DanceScoreFilter.a(this.a, "A");
      return;
    }
    DanceScoreFilter.b(this.a).a(DanceScoreFilter.a(this.a).a.e);
    DanceScoreFilter.a(this.a, "S");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifu
 * JD-Core Version:    0.7.0.1
 */