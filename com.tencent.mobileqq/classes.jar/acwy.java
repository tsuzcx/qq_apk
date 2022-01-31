import android.graphics.Rect;
import android.widget.ImageView.ScaleType;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

public class acwy
  implements OnCompositionLoadedListener
{
  public acwy(IntimateTitleSwitchView paramIntimateTitleSwitchView, String paramString) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((paramLottieComposition == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.c)) {
      if (QLog.isColorLevel()) {
        QLog.d("IntimateTitleSwitchView", 0, "composition is null ,return");
      }
    }
    for (;;)
    {
      return;
      int i = actj.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.getResources());
      int j = actj.a(90.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.getResources());
      Rect localRect = paramLottieComposition.getBounds();
      float f1 = i / localRect.width();
      float f2 = j / localRect.height();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.setImageAssetDelegate(new acwz(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.setScaleXY(f1, f2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.setScaleType(ImageView.ScaleType.FIT_XY);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.playAnimation();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("IntimateTitleSwitchView", 0, "onCompositionLoaded playAnim duration: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.getDuration() + " mIsResumed:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.c);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.cancelAnimation();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView.a.removeAllLottieOnCompositionLoadedListener();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwy
 * JD-Core Version:    0.7.0.1
 */