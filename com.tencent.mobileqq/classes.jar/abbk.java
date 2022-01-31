import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class abbk
  implements Animation.AnimationListener
{
  abbk(abbj paramabbj, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (abbj.a(this.jdField_a_of_type_Abbj) != null) && (abbj.a(this.jdField_a_of_type_Abbj).size() >= 2)) {
      abbj.a(this.jdField_a_of_type_Abbj).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (abbj.a(this.jdField_a_of_type_Abbj) != null)
    {
      abbj.a(this.jdField_a_of_type_Abbj).a();
      abbj.a(this.jdField_a_of_type_Abbj, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abbk
 * JD-Core Version:    0.7.0.1
 */