import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class aenc
  extends AnimatorListenerAdapter
{
  public aenc(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.findViewById(2131370485).setBackgroundDrawable(null);
    this.a.b.findViewById(2131370484).setBackgroundColor(-637534209);
    this.a.c = false;
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    this.a.b.findViewById(2131370485).setBackgroundResource(2130842653);
    this.a.b.findViewById(2131370484).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aenc
 * JD-Core Version:    0.7.0.1
 */