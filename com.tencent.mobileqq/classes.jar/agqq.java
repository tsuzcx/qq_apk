import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.Transformation;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class agqq
  implements ValueAnimation.AnimationUpdateListener
{
  public agqq(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Rect paramRect, Transformation paramTransformation)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.invalidate(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agqq
 * JD-Core Version:    0.7.0.1
 */