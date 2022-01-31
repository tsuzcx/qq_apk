import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class ahvk
  implements Animation.AnimationListener
{
  public ahvk(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (NewFlowCameraActivity.b(this.a) != null) {
      NewFlowCameraActivity.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahvk
 * JD-Core Version:    0.7.0.1
 */