import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

class ahfv
  implements ValueAnimator.AnimatorUpdateListener
{
  ahfv(ahfu paramahfu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (FrameLayout.LayoutParams)this.a.a.a.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.a.a.a.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfv
 * JD-Core Version:    0.7.0.1
 */