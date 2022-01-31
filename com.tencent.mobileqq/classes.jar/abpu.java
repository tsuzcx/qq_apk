import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView.ARMapSplashEntryListener;

public class abpu
  extends AnimatorListenerAdapter
{
  public abpu(ARMapSplashEntryView paramARMapSplashEntryView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ARMapSplashEntryView.a(this.a) != null)
    {
      ARMapSplashEntryView.a(this.a).b();
      ARMapSplashEntryView.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpu
 * JD-Core Version:    0.7.0.1
 */