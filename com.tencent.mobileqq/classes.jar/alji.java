import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class alji
{
  private static final int jdField_a_of_type_Int = Build.VERSION.SDK_INT;
  private static float[] jdField_a_of_type_ArrayOfFloat;
  
  public static void a(float[] paramArrayOfFloat, SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = paramSensorEvent.values;
    if (paramSensorEvent.sensor.getType() == 11)
    {
      if (arrayOfFloat.length > 4)
      {
        if (jdField_a_of_type_Int >= 9)
        {
          c(paramArrayOfFloat, (float[])arrayOfFloat.clone());
          return;
        }
        if (jdField_a_of_type_ArrayOfFloat == null) {
          jdField_a_of_type_ArrayOfFloat = new float[4];
        }
        System.arraycopy(arrayOfFloat, 0, jdField_a_of_type_ArrayOfFloat, 0, 4);
        c(paramArrayOfFloat, jdField_a_of_type_ArrayOfFloat);
        return;
      }
      c(paramArrayOfFloat, (float[])arrayOfFloat.clone());
      return;
    }
    c(paramArrayOfFloat, (float[])arrayOfFloat.clone());
  }
  
  public static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = 0;
    if (i < paramArrayOfFloat2.length)
    {
      if (i < 3) {
        paramArrayOfFloat2[i] = paramArrayOfFloat1[i];
      }
      for (;;)
      {
        i += 1;
        break;
        if ((i > 3) && (i <= 6)) {
          paramArrayOfFloat2[i] = paramArrayOfFloat1[(i - 1)];
        } else if ((i == 3) || (i == 7) || (i == 11)) {
          paramArrayOfFloat2[i] = 0.0F;
        } else if ((i == 12) || (i == 13) || (i == 14)) {
          paramArrayOfFloat2[i] = 0.0F;
        } else if (i == 15) {
          paramArrayOfFloat2[i] = 1.0F;
        } else if ((i > 7) && (i <= 10)) {
          paramArrayOfFloat2[i] = paramArrayOfFloat1[(i - 2)];
        }
      }
    }
  }
  
  public static float[] a(float[] paramArrayOfFloat)
  {
    float f1 = (float)Math.sin(paramArrayOfFloat[1]);
    float f2 = (float)Math.cos(paramArrayOfFloat[1]);
    float f3 = (float)Math.sin(paramArrayOfFloat[2]);
    float f4 = (float)Math.cos(paramArrayOfFloat[2]);
    float f5 = (float)Math.sin(paramArrayOfFloat[0]);
    float f6 = (float)Math.cos(paramArrayOfFloat[0]);
    float f7 = -f1;
    float f8 = -f3;
    float f9 = -f5;
    paramArrayOfFloat = a(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, f2, f1, 0.0F, f7, f2 }, new float[] { f4, 0.0F, f3, 0.0F, 1.0F, 0.0F, f8, 0.0F, f4 });
    return a(new float[] { f6, f5, 0.0F, f9, f6, 0.0F, 0.0F, 0.0F, 1.0F }, paramArrayOfFloat);
  }
  
  public static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[6], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[4] + paramArrayOfFloat1[2] * paramArrayOfFloat2[7], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] + paramArrayOfFloat1[1] * paramArrayOfFloat2[5] + paramArrayOfFloat1[2] * paramArrayOfFloat2[8], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[6], paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7], paramArrayOfFloat1[3] * paramArrayOfFloat2[2] + paramArrayOfFloat1[4] * paramArrayOfFloat2[5] + paramArrayOfFloat1[5] * paramArrayOfFloat2[8], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3] + paramArrayOfFloat1[8] * paramArrayOfFloat2[6], paramArrayOfFloat1[6] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[7], paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8] };
  }
  
  @TargetApi(9)
  public static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    SensorManager.getRotationMatrixFromVector(paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public static void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (jdField_a_of_type_Int >= 9) {
      b(paramArrayOfFloat1, paramArrayOfFloat2);
    }
    float f3;
    float f1;
    float f5;
    float f6;
    float f7;
    float f8;
    float f9;
    float f10;
    float f11;
    do
    {
      return;
      float f2 = paramArrayOfFloat2[0];
      f3 = paramArrayOfFloat2[1];
      float f4 = paramArrayOfFloat2[2];
      if (paramArrayOfFloat2.length == 4) {
        f1 = paramArrayOfFloat2[3];
      }
      for (;;)
      {
        f5 = 2.0F * f2 * f2;
        f6 = 2.0F * f3 * f3;
        f7 = 2.0F * f4 * f4;
        f8 = 2.0F * f2 * f3;
        f9 = 2.0F * f4 * f1;
        f10 = 2.0F * f2 * f4;
        f11 = 2.0F * f3 * f1;
        f3 = f3 * 2.0F * f4;
        f1 *= f2 * 2.0F;
        if (paramArrayOfFloat1.length != 9) {
          break;
        }
        paramArrayOfFloat1[0] = (1.0F - f6 - f7);
        paramArrayOfFloat1[1] = (f8 - f9);
        paramArrayOfFloat1[2] = (f10 + f11);
        paramArrayOfFloat1[3] = (f8 + f9);
        paramArrayOfFloat1[4] = (1.0F - f5 - f7);
        paramArrayOfFloat1[5] = (f3 - f1);
        paramArrayOfFloat1[6] = (f10 - f11);
        paramArrayOfFloat1[7] = (f1 + f3);
        paramArrayOfFloat1[8] = (1.0F - f5 - f6);
        return;
        f1 = 1.0F - f2 * f2 - f3 * f3 - f4 * f4;
        if (f1 > 0.0F) {
          f1 = (float)Math.sqrt(f1);
        } else {
          f1 = 0.0F;
        }
      }
    } while (paramArrayOfFloat1.length != 16);
    paramArrayOfFloat1[0] = (1.0F - f6 - f7);
    paramArrayOfFloat1[1] = (f8 - f9);
    paramArrayOfFloat1[2] = (f10 + f11);
    paramArrayOfFloat1[3] = 0.0F;
    paramArrayOfFloat1[4] = (f8 + f9);
    paramArrayOfFloat1[5] = (1.0F - f5 - f7);
    paramArrayOfFloat1[6] = (f3 - f1);
    paramArrayOfFloat1[7] = 0.0F;
    paramArrayOfFloat1[8] = (f10 - f11);
    paramArrayOfFloat1[9] = (f1 + f3);
    paramArrayOfFloat1[10] = (1.0F - f5 - f6);
    paramArrayOfFloat1[11] = 0.0F;
    paramArrayOfFloat1[14] = 0.0F;
    paramArrayOfFloat1[13] = 0.0F;
    paramArrayOfFloat1[12] = 0.0F;
    paramArrayOfFloat1[15] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alji
 * JD-Core Version:    0.7.0.1
 */