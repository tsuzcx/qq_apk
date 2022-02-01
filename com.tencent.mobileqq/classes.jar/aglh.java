import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.3.1;

public class aglh
  extends blgm
{
  aglh(agle paramagle) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((agle.a(this.a) != null) && (agle.a(this.a).isShown())) {
      this.a.a.post(new ComboAnimation3.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglh
 * JD-Core Version:    0.7.0.1
 */