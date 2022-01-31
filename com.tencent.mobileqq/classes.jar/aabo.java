import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

public class aabo
  implements Runnable
{
  public aabo(AREngine paramAREngine, int paramInt) {}
  
  public void run()
  {
    if ((AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null))
    {
      ARTarget localARTarget = new ARTarget(AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine));
      AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).a(0, localARTarget, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabo
 * JD-Core Version:    0.7.0.1
 */