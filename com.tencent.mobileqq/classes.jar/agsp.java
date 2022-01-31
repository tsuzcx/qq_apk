import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.view.VipProfileWZRYView;

public class agsp
  implements Runnable
{
  public agsp(VipProfileWZRYView paramVipProfileWZRYView) {}
  
  @TargetApi(11)
  public void run()
  {
    this.a.a.setVisibility(0);
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.a.a, "scaleX", new float[] { 3.5F, 0.9F }), ObjectAnimator.ofFloat(this.a.a, "scaleY", new float[] { 3.5F, 0.9F }) });
    localAnimatorSet1.setDuration(150L);
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.a.a, "scaleX", new float[] { 0.9F, 1.1F }), ObjectAnimator.ofFloat(this.a.a, "scaleY", new float[] { 0.9F, 1.1F }) });
    localAnimatorSet2.setDuration(100L);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this.a.a, "scaleX", new float[] { 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.a.a, "scaleY", new float[] { 1.1F, 1.0F }) });
    ((AnimatorSet)localObject).setDuration(50L);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2, localObject });
    localAnimatorSet3.start();
    this.a.c.setVisibility(0);
    localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.a.c, "scaleX", new float[] { 2.0F, 3.0F }), ObjectAnimator.ofFloat(this.a.c, "scaleY", new float[] { 2.0F, 3.0F }), ObjectAnimator.ofFloat(this.a.c, "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet1.setDuration(50L);
    localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.a.c, "scaleX", new float[] { 3.0F, 0.5F }), ObjectAnimator.ofFloat(this.a.c, "scaleY", new float[] { 3.0F, 0.5F }) });
    localAnimatorSet2.setDuration(100L);
    localObject = ObjectAnimator.ofFloat(this.a.c, "alpha", new float[] { 1.0F, 0.0F });
    ((Animator)localObject).setDuration(100L);
    localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2, localObject });
    localAnimatorSet3.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsp
 * JD-Core Version:    0.7.0.1
 */