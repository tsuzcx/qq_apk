import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.lightReply.ImageExplodeLayout;

public class aebr
  extends AnimatorListenerAdapter
{
  public aebr(ImageExplodeLayout paramImageExplodeLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((ViewGroup)this.a.getParent()).removeView(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebr
 * JD-Core Version:    0.7.0.1
 */