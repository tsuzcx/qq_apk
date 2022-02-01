import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class aapv
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public aapv(aapu paramaapu, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Aapu.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        aapu.a(this.jdField_a_of_type_Aapu)[0] = arrayOfFloat[1];
        aapu.a(this.jdField_a_of_type_Aapu)[1] = arrayOfFloat[2];
        aapu.a(this.jdField_a_of_type_Aapu)[2] = arrayOfFloat[3];
        aapu.a(this.jdField_a_of_type_Aapu)[3] = arrayOfFloat[0];
      }
    } while ((!aapu.a()) || (!aapu.b()));
    this.jdField_a_of_type_Aapu.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(aapu.a(this.jdField_a_of_type_Aapu)[0]), String.valueOf(aapu.a(this.jdField_a_of_type_Aapu)[1]), String.valueOf(aapu.a(this.jdField_a_of_type_Aapu)[2]), String.valueOf(aapu.a(this.jdField_a_of_type_Aapu)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapv
 * JD-Core Version:    0.7.0.1
 */