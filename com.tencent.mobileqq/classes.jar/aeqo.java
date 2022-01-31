import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.3.1;

public class aeqo
  extends bhnr
{
  aeqo(aeql paramaeql) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((aeql.a(this.a) != null) && (aeql.a(this.a).isShown())) {
      this.a.a.post(new ComboAnimation3.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqo
 * JD-Core Version:    0.7.0.1
 */