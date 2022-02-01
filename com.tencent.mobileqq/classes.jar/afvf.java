import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.3.1;

public class afvf
  extends bkxp
{
  afvf(afvc paramafvc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((afvc.a(this.a) != null) && (afvc.a(this.a).isShown())) {
      this.a.a.post(new ComboAnimation3.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvf
 * JD-Core Version:    0.7.0.1
 */