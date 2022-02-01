import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class alrp
  implements ValueAnimator.AnimatorUpdateListener
{
  public alrp(LoginView paramLoginView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    int i = (int)((LoginView.b(this.a) - LoginView.c(this.a)) * f + LoginView.c(this.a));
    int j = (int)((LoginView.d(this.a) - LoginView.e(this.a)) * f + LoginView.e(this.a));
    int k = (int)((LoginView.f(this.a) - LoginView.g(this.a)) * f + LoginView.g(this.a));
    int m = (int)((LoginView.h(this.a) - LoginView.i(this.a)) * f + LoginView.i(this.a));
    LoginView.a(this.a, i, j, k, m, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrp
 * JD-Core Version:    0.7.0.1
 */