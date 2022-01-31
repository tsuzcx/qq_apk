import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class alsk
{
  public static void a(View paramView, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramView.setPivotX(paramView.getWidth());
    paramView.setPivotY(paramView.getHeight() / 2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat3, paramFloat4 });
    localAnimatorSet.setDuration(paramInt);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    localAnimatorSet.start();
  }
  
  public static void a(View paramView, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramFloat1, paramFloat2 });
    localAnimatorSet.setDuration(paramInt);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat3, paramFloat4 }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat5, paramFloat6 }) });
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alsk
 * JD-Core Version:    0.7.0.1
 */