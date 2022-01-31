import android.view.animation.DecelerateInterpolator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class ajdd
  implements Runnable
{
  public ajdd(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a, "scrollY", new int[] { this.jdField_a_of_type_Int }).setDuration(this.b);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.addListener(new ajde(this));
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdd
 * JD-Core Version:    0.7.0.1
 */