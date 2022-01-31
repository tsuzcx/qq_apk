import android.animation.ObjectAnimator;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.lang.ref.WeakReference;

public class agjt
  implements Runnable
{
  ObjectAnimator a;
  public WeakReference a;
  public boolean a;
  
  public agjt()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
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
        }
      } while (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      return;
      localImageView.setVisibility(8);
    } while (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjt
 * JD-Core Version:    0.7.0.1
 */