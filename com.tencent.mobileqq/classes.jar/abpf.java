import android.os.Handler;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;

public class abpf
  extends AnimatorListenerAdapter
{
  public abpf(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("onAnimationCancel mNeedLaunchARMapOnAnimEnd=%s", new Object[] { Boolean.valueOf(ARMapLoadingActivity.a(this.a)) }));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("onAnimationEnd mNeedLaunchARMapOnAnimEnd=%s", new Object[] { Boolean.valueOf(ARMapLoadingActivity.a(this.a)) }));
    }
    if (ARMapLoadingActivity.a(this.a))
    {
      ARMapLoadingActivity.a(this.a).sendEmptyMessage(103);
      ARMapLoadingActivity.b(this.a, false);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ARMapLoadingActivity.a(this.a).setLoadStatus(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpf
 * JD-Core Version:    0.7.0.1
 */