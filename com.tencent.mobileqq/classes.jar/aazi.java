import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

public class aazi
  implements Runnable
{
  public aazi(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    ARMapEngine localARMapEngine = this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine;
    ARMapEngine.nativeSetMapRotateMode(this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.getEngineHandler(), this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazi
 * JD-Core Version:    0.7.0.1
 */