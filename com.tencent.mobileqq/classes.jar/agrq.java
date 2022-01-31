import android.graphics.PointF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

public class agrq
  implements Animation.AnimationListener
{
  public agrq(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView;
    paramAnimation.l -= 1;
    paramAnimation = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramAnimation != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getAnimation() != null) {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if ((paramAnimation.a != this.jdField_a_of_type_AndroidGraphicsPointF.x) || (paramAnimation.b != this.jdField_a_of_type_AndroidGraphicsPointF.y))
      {
        paramAnimation.a = this.jdField_a_of_type_AndroidGraphicsPointF.x;
        paramAnimation.b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
        if ((this.jdField_a_of_type_AndroidViewView instanceof VipTagView)) {
          ((VipTagView)this.jdField_a_of_type_AndroidViewView).setShakingState(true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.d = false;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.l == 0) {
        if (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b())
        {
          paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.getLabelList();
          if (paramAnimation != null)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ArrayOfAndroidViewView[(ProfileTagView.a().length - 1)] == null) || (paramAnimation.size() != 0)) {
              break label244;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b.setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.g)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.h(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.g = false;
      }
      return;
      label244:
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agrq
 * JD-Core Version:    0.7.0.1
 */