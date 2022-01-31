import android.graphics.drawable.Drawable;
import android.view.animation.Transformation;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class agck
  implements ValueAnimation.AnimationUpdateListener
{
  public agck(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agck
 * JD-Core Version:    0.7.0.1
 */