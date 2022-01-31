import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;

public class adzd
  implements Animation.AnimationListener
{
  public adzd(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a == 3) {
      this.a.d.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzd
 * JD-Core Version:    0.7.0.1
 */