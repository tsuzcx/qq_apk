import android.animation.ObjectAnimator;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import java.lang.ref.WeakReference;

public class agof
  implements Runnable
{
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  public WeakReference a;
  public boolean a;
  
  public agof()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  }
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (localImageView.getVisibility() == 0);
        int i = localImageView.getLayoutParams().width - AIOUtils.a(46.0F, localImageView.getResources());
        localImageView.setTranslationX(i);
        localImageView.setVisibility(0);
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
        {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localImageView, "translationX", new float[] { i, 0.0F });
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L);
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(500L);
          if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
          {
            agog localagog = new agog(this);
            LottieComposition.Factory.fromAssetFileName(localImageView.getContext(), "qq_ar_scan_entry.json", localagog);
          }
        }
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
      localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
      localImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.end();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agof
 * JD-Core Version:    0.7.0.1
 */