import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aazs
  implements Animator.AnimatorListener
{
  aazs(aazq paramaazq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (aazq.a(this.a) != null) {
      aazq.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aazq.a(this.a) != null) {
      aazq.a(this.a).a();
    }
    if (aazq.a(this.a) != null)
    {
      aazq.a(aazq.a(this.a), null);
      aazq.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (aazq.a(this.a) != null) {
      aazq.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazs
 * JD-Core Version:    0.7.0.1
 */