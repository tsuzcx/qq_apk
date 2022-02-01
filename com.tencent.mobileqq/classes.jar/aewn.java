import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class aewn
  implements Animation.AnimationListener
{
  aewn(aewm paramaewm, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (aewm.a(this.jdField_a_of_type_Aewm) != null) && (aewm.a(this.jdField_a_of_type_Aewm).size() >= 2)) {
      aewm.a(this.jdField_a_of_type_Aewm).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (aewm.a(this.jdField_a_of_type_Aewm) != null)
    {
      aewm.a(this.jdField_a_of_type_Aewm).a();
      aewm.a(this.jdField_a_of_type_Aewm, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewn
 * JD-Core Version:    0.7.0.1
 */