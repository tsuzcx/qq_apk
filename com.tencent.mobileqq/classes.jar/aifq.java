import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLMaskImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class aifq
  implements Animation.AnimationListener
{
  public aifq(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DanceReadyFilter.d(this.a).f_(true);
    DanceReadyFilter.g(this.a).f_(true);
    DanceReadyFilter.a(this.a).f_(false);
    DanceReadyFilter.d(this.a).a(DanceReadyFilter.e(this.a));
    DanceReadyFilter.g(this.a).a(DanceReadyFilter.f(this.a));
    paramAnimation = this.a.a().a();
    if (paramAnimation != null)
    {
      DanceLog.a("DanceReadyFilter", "readySceneBegin begin...");
      paramAnimation.c(DanceReadyFilter.a(this.a));
      DanceLog.a("DanceReadyFilter", "readySceneBegin end...");
      DanceReadyFilter.a(this.a, true);
    }
    DanceReadyFilter.a(this.a);
    TrAsyncTextureLoad.a().b();
    DanceLog.a("DanceReadyFilter", "TrAsyncTextureLoad[enter ready]");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    DanceReadyFilter.a(this.a).f_(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifq
 * JD-Core Version:    0.7.0.1
 */