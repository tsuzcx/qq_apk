import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

class aijx
  extends AnimatorListenerAdapter
{
  aijx(aijw paramaijw) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.r();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aijx
 * JD-Core Version:    0.7.0.1
 */