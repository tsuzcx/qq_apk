import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.AnonymousEntranceView;

public class agxj
  implements Animation.AnimationListener
{
  public agxj(AnonymousEntranceView paramAnonymousEntranceView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AnonymousEntranceView.b(this.a) != null) {
      AnonymousEntranceView.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (AnonymousEntranceView.b(this.a) != null) {
      AnonymousEntranceView.b(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agxj
 * JD-Core Version:    0.7.0.1
 */