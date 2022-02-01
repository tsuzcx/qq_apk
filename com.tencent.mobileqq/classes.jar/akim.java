import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;

public class akim
  implements Animation.AnimationListener
{
  public akim(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a.isFinishing())
    {
      this.a.jdField_a_of_type_Akis.show();
      this.a.b.setAnimation(null);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      NewStyleCountryActivity.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akim
 * JD-Core Version:    0.7.0.1
 */