import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajri
  implements Animator.AnimatorListener
{
  public ajri(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a.r)
    {
      if (ajpx.a == 2) {
        this.a.jdField_a_of_type_Azho.e();
      }
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (NewFlowCameraActivity.i(this.a))
      {
        AVCodec.get().retake();
        wxe.c("PTV.NewFlowCameraActivity", "AVCodec.get().retake() by mbRetake flag");
        NewFlowCameraActivity.i(this.a, false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Ajty.x();
      if (NewFlowCameraActivity.j(this.a))
      {
        if (ajpx.a != 1) {
          break label235;
        }
        NewFlowCameraActivity.a(this.a, true);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Long = System.currentTimeMillis();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double = 0.0D;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.f();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.reset();
        this.a.H();
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "start recording start time=" + this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Long);
        }
        this.a.r = true;
        if (this.a.f) {
          this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
        }
        return;
        label235:
        this.a.jdField_a_of_type_Azho.c(true);
      }
    }
    if (this.a.f) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    paramAnimator = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int i = aepi.a(59.0F, this.a.getResources());
    paramAnimator.width = i;
    paramAnimator.height = i;
    paramAnimator.addRule(13);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAnimator);
    paramAnimator = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    i = aepi.a(84.0F, this.a.getResources());
    paramAnimator.width = i;
    paramAnimator.height = i;
    paramAnimator.addRule(13);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(paramAnimator);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.r = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajri
 * JD-Core Version:    0.7.0.1
 */