import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.Iterator;
import java.util.List;

class alsi
  implements Animator.AnimatorListener
{
  alsi(alsg paramalsg) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    paramAnimator = alsg.a(this.a).iterator();
    while (paramAnimator.hasNext())
    {
      alsj localalsj = (alsj)paramAnimator.next();
      alsj.a(localalsj, alsj.d(localalsj));
      alsj.b(localalsj, (int)(Math.random() * alsg.a(this.a)));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = alsg.a(this.a).iterator();
    while (paramAnimator.hasNext())
    {
      alsj localalsj = (alsj)paramAnimator.next();
      alsj.a(localalsj, alsj.d(localalsj));
      alsj.b(localalsj, (int)(Math.random() * alsg.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alsi
 * JD-Core Version:    0.7.0.1
 */