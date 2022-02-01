import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class aaaj
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public aaaj(aaai paramaaai, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (this.jdField_a_of_type_Byte)
    {
    }
    do
    {
      return;
      float[] arrayOfFloat = new float[4];
      if (Build.VERSION.SDK_INT >= 9)
      {
        SensorManager localSensorManager = this.jdField_a_of_type_Aaai.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        aaai.a(this.jdField_a_of_type_Aaai)[0] = arrayOfFloat[1];
        aaai.a(this.jdField_a_of_type_Aaai)[1] = arrayOfFloat[2];
        aaai.a(this.jdField_a_of_type_Aaai)[2] = arrayOfFloat[3];
        aaai.a(this.jdField_a_of_type_Aaai)[3] = arrayOfFloat[0];
      }
    } while ((!aaai.a()) || (!aaai.b()));
    this.jdField_a_of_type_Aaai.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(aaai.a(this.jdField_a_of_type_Aaai)[0]), String.valueOf(aaai.a(this.jdField_a_of_type_Aaai)[1]), String.valueOf(aaai.a(this.jdField_a_of_type_Aaai)[2]), String.valueOf(aaai.a(this.jdField_a_of_type_Aaai)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaj
 * JD-Core Version:    0.7.0.1
 */