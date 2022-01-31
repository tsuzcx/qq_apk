import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class agdb
  extends AnimateUtils.AnimationAdapter
{
  public agdb(ProfileHeaderView paramProfileHeaderView, View paramView1, View paramView2, Rotate3dAnimation paramRotate3dAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.b.setVisibility(0);
    this.b.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetRotate3dAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdb
 * JD-Core Version:    0.7.0.1
 */