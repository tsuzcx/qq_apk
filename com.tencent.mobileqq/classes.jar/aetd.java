import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class aetd
  implements Animator.AnimatorListener
{
  aetd(aetb paramaetb, LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationCancel drawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationEnd drawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    aetb.a(this.jdField_a_of_type_Aetb, paramAnimator, this.jdField_a_of_type_Int);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel onAnimationStart drawable=" + this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    if ((aetg.a(this.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getSpeed() > 0.0F)) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.reverseAnimationSpeed();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.invalidateDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetd
 * JD-Core Version:    0.7.0.1
 */