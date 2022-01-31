import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class aitr
  implements Animator.AnimatorListener
{
  public aitr(ApolloGuestsStateActivity paramApolloGuestsStateActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ThreadManager.getUIHandler().postDelayed(new ApolloGuestsStateActivity.3.1(this), 200L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aitr
 * JD-Core Version:    0.7.0.1
 */