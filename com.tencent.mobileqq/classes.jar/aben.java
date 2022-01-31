import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.armap.ShopScanDragView;

public class aben
  implements Animator.AnimatorListener
{
  public aben(ShopScanDragView paramShopScanDragView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ShopScanDragView.a(this.a, false);
    ShopScanDragView.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ShopScanDragView.a(this.a, false);
    ShopScanDragView.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aben
 * JD-Core Version:    0.7.0.1
 */