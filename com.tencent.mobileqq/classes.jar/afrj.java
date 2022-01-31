import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;

public class afrj
  extends AnimatorListenerAdapter
{
  public afrj(ARTipsManager paramARTipsManager) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ARTipsManager.a(this.a) != null) {
      ARTipsManager.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrj
 * JD-Core Version:    0.7.0.1
 */