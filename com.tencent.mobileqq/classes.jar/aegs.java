import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class aegs
  implements Animation.AnimationListener
{
  aegs(aegr paramaegr, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (aegr.a(this.jdField_a_of_type_Aegr) != null) && (aegr.a(this.jdField_a_of_type_Aegr).size() >= 2)) {
      aegr.a(this.jdField_a_of_type_Aegr).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (aegr.a(this.jdField_a_of_type_Aegr) != null)
    {
      aegr.a(this.jdField_a_of_type_Aegr).a();
      aegr.a(this.jdField_a_of_type_Aegr, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegs
 * JD-Core Version:    0.7.0.1
 */