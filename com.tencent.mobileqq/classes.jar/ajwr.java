import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;

public class ajwr
  implements Animator.AnimatorListener
{
  public ajwr(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    RedPacketKuaKuaFragment.a(this.a).setRotation(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwr
 * JD-Core Version:    0.7.0.1
 */