import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class agom
  implements ValueAnimator.AnimatorUpdateListener
{
  public agom(SixCombolEffectView paramSixCombolEffectView, agpb paramagpb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Agpb.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Agpb.b) && (this.jdField_a_of_type_Agpb.a < 0.52F)) {
      this.jdField_a_of_type_Agpb.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agom
 * JD-Core Version:    0.7.0.1
 */