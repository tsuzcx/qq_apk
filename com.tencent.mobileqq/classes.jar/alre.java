import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class alre
  implements Animation.AnimationListener
{
  public alre(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (NewFlowCameraActivity.b(this.a) != null) {
      NewFlowCameraActivity.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alre
 * JD-Core Version:    0.7.0.1
 */