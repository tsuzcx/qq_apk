import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;

public class agyk
  implements Animation.AnimationListener
{
  public agyk(ProviderContainerView paramProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (ProviderContainerView.a(this.a) != null)
    {
      ProviderContainerView.a(this.a).setAlpha(1.0F);
      ProviderContainerView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyk
 * JD-Core Version:    0.7.0.1
 */