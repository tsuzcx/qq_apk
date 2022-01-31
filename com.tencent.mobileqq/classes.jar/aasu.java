import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import com.tencent.mobileqq.arcard.ARCardPageProcess.Circle;

public class aasu
  implements ValueAnimator.AnimatorUpdateListener
{
  public aasu(ARCardPageProcess paramARCardPageProcess, ARCardPageProcess.Circle paramCircle) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess$Circle.setTranslationX(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasu
 * JD-Core Version:    0.7.0.1
 */