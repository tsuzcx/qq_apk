import android.hardware.SensorEvent;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.MotionCallback;
import com.tencent.qphone.base.util.QLog;

public class aavr
  implements Runnable
{
  public aavr(ArkAppEventObserverManager paramArkAppEventObserverManager, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[i]));
      ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[0] + ", mMotionY=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[1] + ", mMotionZ=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[2]);
    }
    if (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager) != null) {
      ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager).a(true, ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[0], ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[1], ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavr
 * JD-Core Version:    0.7.0.1
 */