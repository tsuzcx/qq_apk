import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.qphone.base.util.QLog;

public class aagz
  implements Runnable
{
  public aagz(AREngine paramAREngine, boolean paramBoolean) {}
  
  public void run()
  {
    if ((AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != 3) || (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a == null))
    {
      QLog.i("AREngine_AREngine", 2, "cancel to close camera. next mCurCameraState = " + AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine));
      return;
    }
    if ((AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null) && (this.jdField_a_of_type_Boolean)) {
      AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).c();
    }
    if (AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a.a();
    }
    AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, false);
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a.a();
    if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != 3)
    {
      QLog.i("AREngine_AREngine", 2, "cancel to close camera. next mCurCameraState = " + AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine));
      return;
    }
    AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, 0);
    QLog.i("AREngine_AREngine", 2, "closeCamera successfully. mCurCameraState = " + AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagz
 * JD-Core Version:    0.7.0.1
 */