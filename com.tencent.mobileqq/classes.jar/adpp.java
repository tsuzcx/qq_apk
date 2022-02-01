import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class adpp
  implements Animation.AnimationListener
{
  adpp(adpo paramadpo, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (adpo.a(this.jdField_a_of_type_Adpo) != null) && (adpo.a(this.jdField_a_of_type_Adpo).size() >= 2)) {
      adpo.a(this.jdField_a_of_type_Adpo).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (adpo.a(this.jdField_a_of_type_Adpo) != null)
    {
      adpo.a(this.jdField_a_of_type_Adpo).a();
      adpo.a(this.jdField_a_of_type_Adpo, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpp
 * JD-Core Version:    0.7.0.1
 */