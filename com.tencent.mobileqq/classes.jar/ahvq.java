import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class ahvq
  implements Animation.AnimationListener
{
  public ahvq(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NewFlowCameraActivity.a(this.a).setVisibility(4);
    NewFlowCameraActivity.a(this.a).setEnabled(false);
    this.a.e.setVisibility(4);
    ahub.a("", "0X8007C05", this.a.c + "", "", "", "");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    NewFlowCameraActivity.a(this.a).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahvq
 * JD-Core Version:    0.7.0.1
 */