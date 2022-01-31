import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;

public class aagr
  implements Runnable
{
  public aagr(AREngine paramAREngine, ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback) {}
  
  public void run()
  {
    if ((AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null)) {
      AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).a(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagr
 * JD-Core Version:    0.7.0.1
 */