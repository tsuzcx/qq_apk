import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import java.util.ArrayList;

public class aass
  implements Animator.AnimatorListener
{
  public aass(ARCardPageProcess paramARCardPageProcess, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess.jdField_a_of_type_Boolean = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess.b) && (this.jdField_a_of_type_Boolean)) {
      ARCardPageProcess.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess).remove(ARCardPageProcess.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess).size() - 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess.jdField_a_of_type_Boolean = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aass
 * JD-Core Version:    0.7.0.1
 */