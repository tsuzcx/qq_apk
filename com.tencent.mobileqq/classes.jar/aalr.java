import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aalr
  extends AnimatorListenerAdapter
{
  public aalr(ARCardCamereButtonLayout paramARCardCamereButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCamereButtonLayout", 2, "scaleAnimator cancel!");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCamereButtonLayout", 2, "scaleAnimator end, shortVideoShot:" + this.a.a.get() + ", mActionUpAnimator:" + this.a.b.get());
    }
    if (!this.a.b.get())
    {
      this.a.a.set(true);
      ARCardCamereButtonLayout.a(this.a).sendEmptyMessage(2);
      ARCardCamereButtonLayout.a(this.a, System.currentTimeMillis());
      ARCardCamereButtonLayout.a(this.a).sendEmptyMessage(5);
    }
    for (;;)
    {
      this.a.b.set(false);
      return;
      ARCardCamereButtonLayout.a(this.a).setVisibility(8);
      ARCardCamereButtonLayout.a(this.a);
      ARCardCamereButtonLayout.a(this.a, 1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARCardCamereButtonLayout", 2, "scaleAnimator start!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalr
 * JD-Core Version:    0.7.0.1
 */