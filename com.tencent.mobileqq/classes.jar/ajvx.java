import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.qphone.base.util.QLog;

public class ajvx
  implements SensorEventListener
{
  public ajvx(SportManager paramSportManager, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.values[0] > 1.0E+008F) || (NetConnInfoCenter.getServerTimeMillis() > this.jdField_a_of_type_Long))
    {
      QLog.e("SportManager", 1, "unregister listener:" + paramSensorEvent.values[0]);
      if (SportManager.a != null) {
        SportManager.a.unregisterListener(this);
      }
    }
    long l1;
    long l2;
    int i;
    do
    {
      do
      {
        return;
      } while ((SSOHttpUtils.jdField_a_of_type_Long == 0L) || (SSOHttpUtils.jdField_a_of_type_Int == 0));
      l1 = NetConnInfoCenter.getServerTimeMillis();
      l2 = SSOHttpUtils.jdField_a_of_type_Long;
      i = (int)(paramSensorEvent.values[0] - SSOHttpUtils.jdField_a_of_type_Int);
    } while ((l1 - l2 <= this.jdField_a_of_type_Int) || (i <= this.b));
    this.jdField_a_of_type_ComTencentMobileqqVashealthSportManager.a("timer1 report");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajvx
 * JD-Core Version:    0.7.0.1
 */