import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;

public class agnu
  implements AnimationView.MyAnimationListener
{
  public agnu(ThemeHbFragment paramThemeHbFragment) {}
  
  public void onAnimationEnd(AnimationView paramAnimationView) {}
  
  public void onAnimationRepeat(AnimationView paramAnimationView) {}
  
  public void onAnimationStart(AnimationView paramAnimationView)
  {
    if (ThemeHbFragment.a(this.a).getChildCount() > 0) {
      ThemeHbFragment.a(this.a).removeViewAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agnu
 * JD-Core Version:    0.7.0.1
 */