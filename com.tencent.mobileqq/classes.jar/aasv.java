import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import com.tencent.mobileqq.arcard.ARCardPageProcess.Circle;

public class aasv
  implements ValueAnimator.AnimatorUpdateListener
{
  public aasv(ARCardPageProcess paramARCardPageProcess, ARCardPageProcess.Circle paramCircle) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess$Circle.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasv
 * JD-Core Version:    0.7.0.1
 */