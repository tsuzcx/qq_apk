import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.armap.ARMapOpenRedPackDialog;
import com.tencent.mobileqq.portal.SanHuaView;

public class aava
  extends OvershootInterpolator
{
  private boolean jdField_a_of_type_Boolean;
  
  public aava(ARMapOpenRedPackDialog paramARMapOpenRedPackDialog) {}
  
  public float getInterpolation(float paramFloat)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramFloat > 0.7D))
    {
      this.jdField_a_of_type_Boolean = true;
      ARMapOpenRedPackDialog.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapOpenRedPackDialog).a();
    }
    return (float)(1.0D - Math.pow(2.718281828459045D, 5.0F * -paramFloat) * Math.cos(8.0F * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aava
 * JD-Core Version:    0.7.0.1
 */