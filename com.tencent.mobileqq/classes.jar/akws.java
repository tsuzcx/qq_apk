import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.ScrollerRunnable.FlushMessageItemAnimation;

public class akws
  implements Runnable
{
  public akws(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    ScrollerRunnable.FlushMessageItemAnimation localFlushMessageItemAnimation1 = new ScrollerRunnable.FlushMessageItemAnimation(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localFlushMessageItemAnimation1.setFillEnabled(true);
    localFlushMessageItemAnimation1.setDuration(700L);
    ScrollerRunnable.FlushMessageItemAnimation localFlushMessageItemAnimation2 = new ScrollerRunnable.FlushMessageItemAnimation(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localFlushMessageItemAnimation2.setFillEnabled(true);
    localFlushMessageItemAnimation2.setStartTime(700L);
    localFlushMessageItemAnimation2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localFlushMessageItemAnimation1);
    localAnimationSet.addAnimation(localFlushMessageItemAnimation2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new akwt(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
    ScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akws
 * JD-Core Version:    0.7.0.1
 */