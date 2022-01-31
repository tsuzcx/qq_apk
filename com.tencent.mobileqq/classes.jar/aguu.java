import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

public class aguu
  implements Animation.AnimationListener
{
  public aguu(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureFragment", 2, "clearAnimation end!");
    }
    if (EffectsCameraCaptureFragment.d(this.a) == null) {
      return;
    }
    this.a.h = true;
    EffectsCameraCaptureFragment.d(this.a).setText(2131439074);
    EffectsCameraCaptureFragment.d(this.a).startAnimation(this.a.b);
    this.a.a.setStartOffset(3000L);
    this.a.a.setAnimationListener(EffectsCameraCaptureFragment.b(this.a));
    EffectsCameraCaptureFragment.d(this.a).setAnimation(this.a.a);
    this.a.a.startNow();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */