import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.activity.JDHongbaoActivity;

public class aetw
  extends OvershootInterpolator
{
  private boolean jdField_a_of_type_Boolean;
  
  public aetw(JDHongbaoActivity paramJDHongbaoActivity) {}
  
  public float getInterpolation(float paramFloat)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramFloat > 0.7D))
    {
      this.jdField_a_of_type_Boolean = true;
      JDHongbaoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJDHongbaoActivity).setBackgroundColor(-16777216);
      JDHongbaoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJDHongbaoActivity).startAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityJDHongbaoActivity.a);
    }
    return (float)(1.0D - Math.pow(2.718281828459045D, 5.0F * -paramFloat) * Math.cos(8.0F * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetw
 * JD-Core Version:    0.7.0.1
 */