import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class alzf
  implements SensorEventListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  boolean jdField_a_of_type_Boolean = false;
  
  public alzf(Context paramContext, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null)
    {
      QLog.e("ApolloRender", 1, "SensorManager is null");
      alvx.a().callbackFromRequest(this.jdField_a_of_type_Long, 1, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4);
    if (localObject == null)
    {
      QLog.e("ApolloRender", 1, "Sensor gyro is null");
      alvx.a().callbackFromRequest(this.jdField_a_of_type_Long, 2, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
    boolean bool = this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, (Sensor)localObject, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    localObject = alvx.a();
    long l = this.jdField_a_of_type_Long;
    if (bool) {}
    for (int i = 0;; i = 5)
    {
      ((ApolloCmdChannel)localObject).callbackFromRequest(l, i, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null)
    {
      QLog.e("ApolloRender", 1, "SensorManager is null");
      return;
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    this.jdField_a_of_type_Boolean = false;
    QLog.e("ApolloRender", 1, "Sensor unRegister");
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      paramSensorEvent = paramSensorEvent.values;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("gyroX", paramSensorEvent[0]);
      localJSONObject.put("gyroY", paramSensorEvent[1]);
      localJSONObject.put("gyroZ", paramSensorEvent[2]);
      alvx.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_device_gyro_sensor_scope_update.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramSensorEvent)
    {
      QLog.e("ApolloRender", 1, paramSensorEvent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzf
 * JD-Core Version:    0.7.0.1
 */