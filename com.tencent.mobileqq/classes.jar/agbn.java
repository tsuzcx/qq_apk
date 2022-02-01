import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.3.1;

public class agbn
  extends bkfi
{
  agbn(agbk paramagbk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((agbk.a(this.a) != null) && (agbk.a(this.a).isShown())) {
      this.a.a.post(new ComboAnimation3.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbn
 * JD-Core Version:    0.7.0.1
 */