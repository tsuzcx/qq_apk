import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;

public class aksk
  implements Animator.AnimatorListener
{
  public aksk(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    RedPacketKuaKuaFragment.a(this.a).setRotation(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */