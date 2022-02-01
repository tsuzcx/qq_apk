import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class aazv
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public aazv(aazu paramaazu, byte paramByte, String paramString)
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
        SensorManager localSensorManager = this.jdField_a_of_type_Aazu.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        aazu.a(this.jdField_a_of_type_Aazu)[0] = arrayOfFloat[1];
        aazu.a(this.jdField_a_of_type_Aazu)[1] = arrayOfFloat[2];
        aazu.a(this.jdField_a_of_type_Aazu)[2] = arrayOfFloat[3];
        aazu.a(this.jdField_a_of_type_Aazu)[3] = arrayOfFloat[0];
      }
    } while ((!aazu.a()) || (!aazu.b()));
    this.jdField_a_of_type_Aazu.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(aazu.a(this.jdField_a_of_type_Aazu)[0]), String.valueOf(aazu.a(this.jdField_a_of_type_Aazu)[1]), String.valueOf(aazu.a(this.jdField_a_of_type_Aazu)[2]), String.valueOf(aazu.a(this.jdField_a_of_type_Aazu)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazv
 * JD-Core Version:    0.7.0.1
 */