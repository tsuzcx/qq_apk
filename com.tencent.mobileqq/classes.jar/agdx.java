import android.graphics.PointF;
import android.view.animation.Transformation;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class agdx
  implements ValueAnimation.AnimationUpdateListener
{
  public agdx(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, PointF paramPointF, Transformation paramTransformation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, paramPointF.x, paramPointF.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdx
 * JD-Core Version:    0.7.0.1
 */