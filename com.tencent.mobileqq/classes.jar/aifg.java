import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;

public class aifg
  implements Animation.AnimationListener
{
  public aifg(AbsPublishActivity paramAbsPublishActivity, Animation paramAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.b.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aifg
 * JD-Core Version:    0.7.0.1
 */