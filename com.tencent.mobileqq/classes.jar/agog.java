import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.lang.ref.WeakReference;

class agog
  implements OnCompositionLoadedListener
{
  agog(agof paramagof) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = new LottieDrawable();
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setComposition(paramLottieComposition);
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(new agoh(this));
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.loop(true);
      paramLottieComposition = (ImageView)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((paramLottieComposition == null) || (paramLottieComposition.getVisibility() != 0) || (this.a.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()));
    paramLottieComposition.setImageDrawable(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agog
 * JD-Core Version:    0.7.0.1
 */