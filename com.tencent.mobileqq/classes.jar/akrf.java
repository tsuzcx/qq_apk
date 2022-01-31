import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.qphone.base.util.QLog;

public class akrf
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  private float d;
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    HealthStepCounterPlugin.b = 1;
    HealthStepCounterPlugin.a = true;
  }
  
  public void b()
  {
    HealthStepCounterPlugin.b = 3;
    QLog.d("HealthStepCounterPlugin", 1, "shaking end");
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = 0.0F;
    float f2;
    float f3;
    float f4;
    long l1;
    long l2;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f2 = paramSensorEvent.values[0];
      f3 = paramSensorEvent.values[1];
      f4 = paramSensorEvent.values[2];
      l1 = System.currentTimeMillis();
      l2 = l1 - this.jdField_a_of_type_Long;
      if (l2 <= 5000L) {
        break label66;
      }
      a(l1);
    }
    label66:
    do
    {
      do
      {
        return;
      } while (l2 <= 80L);
      if ((this.jdField_a_of_type_Float != 0.0F) || (this.b != 0.0F) || (this.c != 0.0F)) {
        f1 = Math.abs(f2 - this.jdField_a_of_type_Float) + Math.abs(f3 - this.b) + Math.abs(f4 - this.c);
      }
      this.d = (f1 + this.d);
      if ((this.d > 180.0F) && (this.jdField_a_of_type_Int >= 3))
      {
        a();
        a(l1);
        return;
      }
      if (this.jdField_a_of_type_Int < 10)
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_Float = f2;
        this.b = f3;
        this.c = f4;
        this.jdField_a_of_type_Long = l1;
        return;
      }
      a(l1);
    } while (HealthStepCounterPlugin.b >= 3);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrf
 * JD-Core Version:    0.7.0.1
 */