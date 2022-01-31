import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;

public class ahky
  implements Animator.AnimatorListener
{
  public ahky(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    CameraCaptureButtonLayout.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahky
 * JD-Core Version:    0.7.0.1
 */