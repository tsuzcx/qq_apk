import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class afaj
  extends AnimatorListenerAdapter
{
  public afaj(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.findViewById(2131370630).setVisibility(8);
    this.a.c = false;
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b.findViewById(2131370630).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afaj
 * JD-Core Version:    0.7.0.1
 */