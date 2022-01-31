import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class alor
  implements SensorEventListener
{
  alor(aloo paramaloo) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1) {
      aloo.a(this.a, paramSensorEvent);
    }
    while (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    aloo.b(this.a, paramSensorEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alor
 * JD-Core Version:    0.7.0.1
 */