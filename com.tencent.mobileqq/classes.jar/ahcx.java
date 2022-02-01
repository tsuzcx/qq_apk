import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

final class ahcx
  implements OnCompositionLoadedListener
{
  ahcx(DiniFlyAnimationView paramDiniFlyAnimationView, agsz paramagsz, String paramString) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new ahcy(this));
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ahcw.jdField_a_of_type_JavaLangString, 2, "composition is null ,return");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(paramLottieComposition);
    if ((this.jdField_a_of_type_Agsz != null) && ("bubble".equals(this.jdField_a_of_type_JavaLangString)))
    {
      paramLottieComposition = this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getCompRect();
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
      int i = paramLottieComposition.width() * localLayoutParams.height / paramLottieComposition.height();
      this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams().width = i;
      this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_Agsz.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_Agsz.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      this.jdField_a_of_type_Agsz.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcx
 * JD-Core Version:    0.7.0.1
 */