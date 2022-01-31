import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ablc
  implements Animation.AnimationListener
{
  ablc(ablb paramablb, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (ablb.a(this.jdField_a_of_type_Ablb) != null) && (ablb.a(this.jdField_a_of_type_Ablb).size() >= 2)) {
      ablb.a(this.jdField_a_of_type_Ablb).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (ablb.a(this.jdField_a_of_type_Ablb) != null)
    {
      ablb.a(this.jdField_a_of_type_Ablb).a();
      ablb.a(this.jdField_a_of_type_Ablb, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablc
 * JD-Core Version:    0.7.0.1
 */