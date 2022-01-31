import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class aeas
  extends AnimatorListenerAdapter
{
  public aeas(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.a) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeas
 * JD-Core Version:    0.7.0.1
 */