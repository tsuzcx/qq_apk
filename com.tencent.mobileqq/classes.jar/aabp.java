import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.qphone.base.util.QLog;

public class aabp
  implements Runnable
{
  public aabp(AREngine paramAREngine, int paramInt) {}
  
  public void run()
  {
    if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == null) {
      QLog.d("AREngine_AREngine", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).c()) {
          break label289;
        }
        if ((!AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).g()) && (!AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).f()) && (!AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).j())) {
          break label191;
        }
        if ((!AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).i()) || ((AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).f()) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).i()))) {
          AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, true);
        }
      }
      label289:
      while ((AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null))
      {
        ARTarget localARTarget = new ARTarget(AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine));
        AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).a(1, localARTarget, this.jdField_a_of_type_Int);
        return;
        label191:
        if (!AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).i())
        {
          if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 1L)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.b(1L);
            AREngine.c(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.j();
            break;
            if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2L) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.l();
            } else if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2048L) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.n();
            }
          }
          if ((AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).f()) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).i())) {
            AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabp
 * JD-Core Version:    0.7.0.1
 */