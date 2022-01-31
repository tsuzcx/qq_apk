import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView.2.1;
import com.tencent.widget.HorizontalListView;

public class aiwx
  implements Animation.AnimationListener
{
  public aiwx(CmGameDebugView paramCmGameDebugView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (CmGameDebugView.a(this.a))
    {
      CmGameDebugView.a(this.a).postDelayed(new CmGameDebugView.2.1(this), 0L);
      CmGameDebugView.a(this.a, false);
    }
    if (CmGameDebugView.b(this.a)) {
      CmGameDebugView.b(this.a, 0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwx
 * JD-Core Version:    0.7.0.1
 */