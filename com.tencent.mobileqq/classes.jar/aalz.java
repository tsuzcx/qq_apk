import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import java.util.List;

public class aalz
  implements ViewPager.OnPageChangeListener
{
  public aalz(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    
    if ((RelativePersonalBottomView.a(this.a) != null) && (RelativePersonalBottomView.a(this.a).getChildCount() > paramInt)) {
      RelativePersonalBottomView.a(this.a).getChildAt(paramInt).performClick();
    }
    if (RelativePersonalBottomView.a(this.a).size() > paramInt) {
      ((SubscribeBaseBottomPersonalFragment)RelativePersonalBottomView.a(this.a).get(paramInt)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalz
 * JD-Core Version:    0.7.0.1
 */