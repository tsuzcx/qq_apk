import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView.PopUpListener;

public class agkc
  implements Animator.AnimatorListener
{
  public agkc(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkc
 * JD-Core Version:    0.7.0.1
 */