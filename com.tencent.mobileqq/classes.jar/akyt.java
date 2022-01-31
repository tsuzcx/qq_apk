import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;

public class akyt
  implements Animation.AnimationListener
{
  public akyt(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a.getView();
    ImageView localImageView = (ImageView)paramAnimation.findViewById(2131375470);
    localImageView.setVisibility(8);
    if (WorldCupShareFragment.a(this.a) != null)
    {
      WorldCupShareFragment.a(this.a).cancelAnimation();
      WorldCupShareFragment.a(this.a, null);
    }
    localImageView.setImageDrawable(null);
    WorldCupShareFragment.a(this.a, paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyt
 * JD-Core Version:    0.7.0.1
 */