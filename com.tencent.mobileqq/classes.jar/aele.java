import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.activity.aio.AudioSenorManager;
import com.tencent.qphone.base.util.QLog;

public class aele
  implements SensorEventListener
{
  public aele(AudioSenorManager paramAudioSenorManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f6;
    float f5;
    float f4;
    float f3;
    float f2;
    float f1;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      f6 = paramSensorEvent.values[0];
      f5 = paramSensorEvent.values[1];
      f4 = paramSensorEvent.values[2];
      f3 = f4;
      f2 = f5;
      f1 = f6;
      if (AudioSenorManager.a())
      {
        f1 = f6 * 10.0F;
        f2 = f5 * 10.0F;
        f3 = f4 * 10.0F;
      }
      if ((this.a.jdField_a_of_type_Float != -999.0F) || (this.a.b != -999.0F) || (this.a.c != -999.0F)) {
        break label135;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Float = f1;
      this.a.b = f2;
      this.a.c = f3;
      return;
      label135:
      f4 = Math.abs(this.a.jdField_a_of_type_Float - f1);
      f5 = Math.abs(this.a.b - f2);
      f6 = Math.abs(this.a.c - f3);
      if ((f4 >= AudioSenorManager.a(this.a)) || (f5 >= AudioSenorManager.a(this.a)) || (f6 >= AudioSenorManager.a(this.a)))
      {
        if ((!this.a.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
          QLog.d("AudioSenorManager", 2, "AccelerationListener$onSensorChanged moving | x=" + f1 + " | y = " + f2 + " | z = " + f3 + " | ax = " + f4 + " | ay = " + f5 + " | az = " + f6 + " | value=" + AudioSenorManager.a(this.a));
        }
        this.a.jdField_a_of_type_Boolean = true;
      }
      else if ((f4 < AudioSenorManager.b(this.a)) && (f5 < AudioSenorManager.b(this.a)) && (f6 < AudioSenorManager.b(this.a)))
      {
        if ((this.a.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
          QLog.d("AudioSenorManager", 2, "AccelerationListener$onSensorChanged stop moving | x=" + f1 + " | y = " + f2 + " | z = " + f3 + " | ax = " + f4 + " | ay = " + f5 + " | az = " + f6 + " | value=" + AudioSenorManager.a(this.a));
        }
        this.a.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aele
 * JD-Core Version:    0.7.0.1
 */