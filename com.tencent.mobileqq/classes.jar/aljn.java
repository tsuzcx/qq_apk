import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.AnonymousEntranceView;

public class aljn
  implements Animation.AnimationListener
{
  public aljn(AnonymousEntranceView paramAnonymousEntranceView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljn
 * JD-Core Version:    0.7.0.1
 */