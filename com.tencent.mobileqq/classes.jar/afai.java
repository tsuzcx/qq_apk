import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class afai
  extends AnimatorListenerAdapter
{
  public afai(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.findViewById(2131370626).setBackgroundDrawable(null);
    this.a.b.findViewById(2131370625).setBackgroundColor(-637534209);
    this.a.c = false;
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    this.a.b.findViewById(2131370626).setBackgroundResource(2130842752);
    this.a.b.findViewById(2131370625).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afai
 * JD-Core Version:    0.7.0.1
 */