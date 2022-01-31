import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class altq
  implements Animator.AnimatorListener
{
  altq(altj paramaltj, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    altj.b(this.jdField_a_of_type_Altj).scrollTo(0, 0);
    altj.b(this.jdField_a_of_type_Altj).setAlpha(1.0F);
    altj.b(this.jdField_a_of_type_Altj).setBackgroundColor(altj.a(this.jdField_a_of_type_Altj).getResources().getColor(altj.a()));
    paramAnimator = this.jdField_a_of_type_Altj.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_Altj.a.getMeasuredWidth();; f = this.jdField_a_of_type_Altj.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_Altj.a.setAlpha(0.0F);
      this.jdField_a_of_type_Altj.a.setVisibility(0);
      this.jdField_a_of_type_Altj.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altq
 * JD-Core Version:    0.7.0.1
 */