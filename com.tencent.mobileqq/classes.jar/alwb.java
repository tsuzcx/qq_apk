import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RunnableUpdateThumb;

public class alwb
  implements Animator.AnimatorListener
{
  public alwb(NewFlowCameraActivity.RunnableUpdateThumb paramRunnableUpdateThumb) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwb
 * JD-Core Version:    0.7.0.1
 */