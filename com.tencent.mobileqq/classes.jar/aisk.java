import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.util.DisplayUtil;

public class aisk
  implements ValueAnimator.AnimatorUpdateListener
{
  public aisk(TribePostTitlePrefixPanelController paramTribePostTitlePrefixPanelController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    TribePostTitlePrefixPanelController.a(this.a).setPadding(DisplayUtil.a(TribePostTitlePrefixPanelController.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisk
 * JD-Core Version:    0.7.0.1
 */