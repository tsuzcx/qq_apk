import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class akas
  implements Animation.AnimationListener
{
  public akas(SpecailCareListActivity paramSpecailCareListActivity, akbh paramakbh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Akbh.c.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akas
 * JD-Core Version:    0.7.0.1
 */