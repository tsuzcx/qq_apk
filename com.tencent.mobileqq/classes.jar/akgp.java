import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import java.util.List;

public class akgp
  implements ValueAnimator.AnimatorUpdateListener
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  private IntEvaluator jdField_a_of_type_AndroidAnimationIntEvaluator = new IntEvaluator();
  
  public akgp(AvatarPendantActivity paramAvatarPendantActivity, List paramList1, List paramList2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramValueAnimator = (View)this.jdField_a_of_type_JavaUtilList.get(i);
      akgr localakgr = (akgr)this.b.get(i);
      ViewGroup.LayoutParams localLayoutParams = paramValueAnimator.getLayoutParams();
      if (localakgr.jdField_a_of_type_Int != localakgr.b)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)paramValueAnimator.getLayoutParams();
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localakgr.jdField_a_of_type_Int), Integer.valueOf(localakgr.b)).intValue();
        paramValueAnimator.setLayoutParams(localLayoutParams1);
      }
      if (localakgr.c != localakgr.d) {
        localLayoutParams.height = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localakgr.c), Integer.valueOf(localakgr.d)).intValue();
      }
      if (localakgr.e != localakgr.f) {
        localLayoutParams.width = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localakgr.e), Integer.valueOf(localakgr.f)).intValue();
      }
      paramValueAnimator.setLayoutParams(localLayoutParams);
      paramValueAnimator.requestLayout();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akgp
 * JD-Core Version:    0.7.0.1
 */