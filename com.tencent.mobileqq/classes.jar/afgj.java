import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.AnimationEndClearListener.1;

public class afgj
  implements Animation.AnimationListener
{
  public int a;
  public View a;
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.postDelayed(new TroopMemberListActivity.AnimationEndClearListener.1(this), 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = (String)this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_Int == 1) && (paramAnimation.equals("left")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
    if ((this.jdField_a_of_type_Int == 0) && (paramAnimation.equals("right")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgj
 * JD-Core Version:    0.7.0.1
 */