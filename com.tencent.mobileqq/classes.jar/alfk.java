import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class alfk
  implements SensorEventListener
{
  alfk(alfj paramalfj) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    double d1 = 1.0D;
    if (1 != paramSensorEvent.sensor.getType()) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    float f1 = paramSensorEvent[0];
    float f2 = paramSensorEvent[1];
    double d2 = Math.sqrt(f1 * f1 + f2 * f2);
    d2 = f2 / d2;
    if (d2 > 1.0D) {}
    for (;;)
    {
      d2 = Math.acos(d1);
      d1 = d2;
      if (f1 < 0.0F) {
        d1 = 6.283185307179586D - d2;
      }
      int i = (int)(d1 * 57.295779513082323D);
      alfj.a(this.a, (i + 45) / 90 * 90);
      return;
      if (d2 < -1.0D) {
        d1 = -1.0D;
      } else {
        d1 = d2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfk
 * JD-Core Version:    0.7.0.1
 */