import android.hardware.SensorEvent;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.OrientationCallback;
import com.tencent.qphone.base.util.QLog;

public class aahx
  implements Runnable
{
  public aahx(ArkAppEventObserverManager paramArkAppEventObserverManager, long paramLong, SensorEvent paramSensorEvent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange curTime=" + this.jdField_a_of_type_Long + ", event[0]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0] + ", event[1]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1] + ", event[2]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    }
    ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager, 360.0F - this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0]);
    ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1]);
    ArkAppEventObserverManager.c(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange update alpha=" + ArkAppEventObserverManager.c(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager) + ", update beta=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager) + ", update gamma=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager));
    }
    if (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager) != null) {
      ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager).a(true, ArkAppEventObserverManager.c(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager), ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager), ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahx
 * JD-Core Version:    0.7.0.1
 */