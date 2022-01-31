import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ablg
  implements Animation.AnimationListener
{
  ablg(ablf paramablf, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (ablf.a(this.jdField_a_of_type_Ablf) != null) && (ablf.a(this.jdField_a_of_type_Ablf).size() >= 2)) {
      ablf.a(this.jdField_a_of_type_Ablf).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (ablf.a(this.jdField_a_of_type_Ablf) != null)
    {
      ablf.a(this.jdField_a_of_type_Ablf).a();
      ablf.a(this.jdField_a_of_type_Ablf, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablg
 * JD-Core Version:    0.7.0.1
 */