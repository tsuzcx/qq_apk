import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RunnableUpdateThumb;

public class ajrt
  implements Animator.AnimatorListener
{
  public ajrt(NewFlowCameraActivity.RunnableUpdateThumb paramRunnableUpdateThumb) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((NewFlowCameraActivity.a(this.a.this$0) != null) && (NewFlowCameraActivity.b(this.a.this$0) != null) && (NewFlowCameraActivity.a(this.a.this$0) != null))
    {
      NewFlowCameraActivity.a(this.a.this$0).setVisibility(8);
      NewFlowCameraActivity.b(this.a.this$0).setImageBitmap(this.a.b);
      NewFlowCameraActivity.b(this.a.this$0).setVisibility(0);
      NewFlowCameraActivity.a(this.a.this$0).setText(NewFlowCameraActivity.c(this.a.this$0) + "");
      NewFlowCameraActivity.a(this.a.this$0).setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrt
 * JD-Core Version:    0.7.0.1
 */