import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.util.DisplayUtil;

public class aiei
  implements Animator.AnimatorListener
{
  public aiei(TribePostTitlePrefixPanelController paramTribePostTitlePrefixPanelController) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    TribePostTitlePrefixPanelController.a(this.a).setPadding(DisplayUtil.a(TribePostTitlePrefixPanelController.a(this.a).getContext(), 8.0F), -TribePostTitlePrefixPanelController.a(this.a), 0, 0);
    TribePostTitlePrefixPanelController.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TribePostTitlePrefixPanelController.a(this.a).setPadding(DisplayUtil.a(TribePostTitlePrefixPanelController.a(this.a).getContext(), 8.0F), 0, 0, 0);
    TribePostTitlePrefixPanelController.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    TribePostTitlePrefixPanelController.a(this.a).setPadding(DisplayUtil.a(TribePostTitlePrefixPanelController.a(this.a).getContext(), 8.0F), -TribePostTitlePrefixPanelController.a(this.a), 0, 0);
    TribePostTitlePrefixPanelController.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiei
 * JD-Core Version:    0.7.0.1
 */