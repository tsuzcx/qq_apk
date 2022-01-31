import android.os.Handler;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.test.joystick.JoystickListener;

public class aatm
  implements JoystickListener
{
  public aatm(ARMapActivity paramARMapActivity) {}
  
  public void a()
  {
    ARMapActivity.h(this.a, true);
    this.a.jdField_a_of_type_AndroidOsHandler.post(new aatn(this));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    ARMapActivity.b(this.a, paramFloat1);
    ARMapActivity.c(this.a, paramFloat2);
  }
  
  public void b()
  {
    ARMapActivity.h(this.a, false);
    this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aato(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatm
 * JD-Core Version:    0.7.0.1
 */