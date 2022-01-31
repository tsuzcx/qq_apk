import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class adcf
  implements Animation.AnimationListener
{
  adcf(adce paramadce, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (adce.a(this.jdField_a_of_type_Adce) != null) && (adce.a(this.jdField_a_of_type_Adce).size() >= 2)) {
      adce.a(this.jdField_a_of_type_Adce).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (adce.a(this.jdField_a_of_type_Adce) != null)
    {
      adce.a(this.jdField_a_of_type_Adce).a();
      adce.a(this.jdField_a_of_type_Adce, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcf
 * JD-Core Version:    0.7.0.1
 */