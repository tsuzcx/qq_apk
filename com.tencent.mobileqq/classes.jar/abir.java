import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView.ARMapSplashEntryListener;

public class abir
  extends AnimatorListenerAdapter
{
  public abir(ARMapSplashEntryView paramARMapSplashEntryView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ARMapSplashEntryView.a(this.a) != null) {
      ARMapSplashEntryView.a(this.a).a();
    }
    ARMapSplashEntryView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abir
 * JD-Core Version:    0.7.0.1
 */