import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import java.util.List;

public class agic
  implements ValueAnimator.AnimatorUpdateListener
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  private IntEvaluator jdField_a_of_type_AndroidAnimationIntEvaluator = new IntEvaluator();
  
  public agic(AvatarPendantActivity paramAvatarPendantActivity, List paramList1, List paramList2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramValueAnimator = (View)this.jdField_a_of_type_JavaUtilList.get(i);
      agif localagif = (agif)this.b.get(i);
      ViewGroup.LayoutParams localLayoutParams = paramValueAnimator.getLayoutParams();
      if (localagif.jdField_a_of_type_Int != localagif.b)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)paramValueAnimator.getLayoutParams();
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localagif.jdField_a_of_type_Int), Integer.valueOf(localagif.b)).intValue();
        paramValueAnimator.setLayoutParams(localLayoutParams1);
      }
      if (localagif.c != localagif.d) {
        localLayoutParams.height = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localagif.c), Integer.valueOf(localagif.d)).intValue();
      }
      if (localagif.e != localagif.f) {
        localLayoutParams.width = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localagif.e), Integer.valueOf(localagif.f)).intValue();
      }
      paramValueAnimator.setLayoutParams(localLayoutParams);
      paramValueAnimator.requestLayout();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agic
 * JD-Core Version:    0.7.0.1
 */