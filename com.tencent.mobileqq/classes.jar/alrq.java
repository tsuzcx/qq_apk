import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class alrq
  implements Animator.AnimatorListener
{
  public alrq(LoginView paramLoginView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    LoginView.c(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LoginView.a(this.a, LoginView.b(this.a), LoginView.d(this.a), LoginView.f(this.a), LoginView.h(this.a), 1.0F);
    if (this.a.a != null) {
      this.a.a.e();
    }
    LoginView.c(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrq
 * JD-Core Version:    0.7.0.1
 */