import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

public class afuv
  implements Animation.AnimationListener
{
  public afuv(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = ((RelativeLayout.LayoutParams)this.a.a.getLayoutParams()).topMargin;
    int j = MiniMsgTabFragment.b(this.a);
    int k = MiniMsgTabFragment.c(this.a);
    int m = MiniMsgTabFragment.a(this.a).getHeight();
    this.a.a.setMaxHeight(j - k - i - m);
    this.a.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuv
 * JD-Core Version:    0.7.0.1
 */