import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class abdy
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public abdy(abdx paramabdx, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Abdx.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        abdx.a(this.jdField_a_of_type_Abdx)[0] = arrayOfFloat[1];
        abdx.a(this.jdField_a_of_type_Abdx)[1] = arrayOfFloat[2];
        abdx.a(this.jdField_a_of_type_Abdx)[2] = arrayOfFloat[3];
        abdx.a(this.jdField_a_of_type_Abdx)[3] = arrayOfFloat[0];
      }
    } while ((!abdx.a()) || (!abdx.b()));
    this.jdField_a_of_type_Abdx.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(abdx.a(this.jdField_a_of_type_Abdx)[0]), String.valueOf(abdx.a(this.jdField_a_of_type_Abdx)[1]), String.valueOf(abdx.a(this.jdField_a_of_type_Abdx)[2]), String.valueOf(abdx.a(this.jdField_a_of_type_Abdx)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abdy
 * JD-Core Version:    0.7.0.1
 */