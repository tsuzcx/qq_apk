import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.qphone.base.util.QLog;

public class abbi
  implements Runnable
{
  public abbi(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    if ((this.a.app == null) || (this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView == null)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapActivity", 4, "init ARMapTracer");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer = new ARMapTracer(true, this.a.app.getAccount(), 10, new abbj(this));
    this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setTraceCallback(this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbi
 * JD-Core Version:    0.7.0.1
 */