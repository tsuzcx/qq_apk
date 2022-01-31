import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.arcard.ARCardPageProcess;
import com.tencent.mobileqq.arcard.ARCardPageProcess.Circle;

public class aafa
  implements ValueAnimator.AnimatorUpdateListener
{
  public aafa(ARCardPageProcess paramARCardPageProcess, ARCardPageProcess.Circle paramCircle) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess$Circle.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafa
 * JD-Core Version:    0.7.0.1
 */