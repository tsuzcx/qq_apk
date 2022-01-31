import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class aljk
  extends aljo
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = -1.0F;
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = -1.0F;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = -1.0F;
  private final float[] jdField_d_of_type_ArrayOfFloat = new float[4];
  private float[] e = new float[3];
  private float[] f = new float[3];
  private float[] g = new float[3];
  private float[] h = new float[3];
  private float[] i = new float[3];
  private float[] j = new float[9];
  private float[] k = new float[3];
  private float[] l = new float[9];
  private float[] m = new float[16];
  
  public aljk(Context paramContext, int paramInt, SensorManager paramSensorManager, aljg paramaljg)
  {
    super(paramContext, paramInt, paramSensorManager, paramaljg);
    paramContext = paramSensorManager.getDefaultSensor(4);
    paramaljg = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (paramaljg != null) && (paramSensorManager != null))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramContext);
      this.jdField_a_of_type_JavaUtilList.add(paramaljg);
      this.jdField_a_of_type_JavaUtilList.add(paramSensorManager);
      a();
      return;
    }
    throw new OrientationProviderNotFound("4,1,2");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.jdField_a_of_type_Aljg == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.jdField_b_of_type_Float) > 1.0F)
    {
      this.jdField_b_of_type_Float = paramFloat1;
      this.jdField_a_of_type_Aljg.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.jdField_c_of_type_Float) > 1.0F)
    {
      this.jdField_c_of_type_Float = paramFloat2;
      this.jdField_a_of_type_Aljg.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.jdField_d_of_type_Float) > 1.0F)
    {
      this.jdField_d_of_type_Float = paramFloat3;
      this.jdField_a_of_type_Aljg.updateRoll(paramFloat3);
    }
    this.jdField_a_of_type_Aljg.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_Aljg == null) {
      return;
    }
    this.jdField_a_of_type_Aljg.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float[] arrayOfFloat;
    if (!this.jdField_c_of_type_Boolean)
    {
      arrayOfFloat = new float[9];
      arrayOfFloat = alji.a(this.k);
      SensorManager.getOrientation(arrayOfFloat, new float[3]);
      this.l = alji.a(this.l, arrayOfFloat);
      this.jdField_c_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Float != 0.0F) && (this.jdField_c_of_type_Boolean))
    {
      float f7 = (float)paramSensorEvent.timestamp;
      float f8 = this.jdField_a_of_type_Float;
      System.arraycopy(paramSensorEvent.values, 0, this.i, 0, 3);
      float f6 = this.i[0];
      float f5 = this.i[1];
      float f4 = this.i[2];
      float f9 = (float)Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
      float f3 = f4;
      float f2 = f5;
      float f1 = f6;
      if (f9 > 1.0E-009F)
      {
        f1 = f6 / f9;
        f2 = f5 / f9;
        f3 = f4 / f9;
      }
      f5 = (f7 - f8) * 1.0E-009F * f9 / 2.0F;
      f4 = (float)Math.sin(f5);
      f5 = (float)Math.cos(f5);
      this.jdField_d_of_type_ArrayOfFloat[0] = (f1 * f4);
      this.jdField_d_of_type_ArrayOfFloat[1] = (f2 * f4);
      this.jdField_d_of_type_ArrayOfFloat[2] = (f3 * f4);
      this.jdField_d_of_type_ArrayOfFloat[3] = f5;
      arrayOfFloat = new float[9];
      alji.c(arrayOfFloat, this.jdField_d_of_type_ArrayOfFloat);
      this.l = alji.a(this.l, arrayOfFloat);
      SensorManager.getOrientation(this.l, this.e);
      e();
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Aljg != null)) {
        a((float)(Math.toDegrees(this.e[0] + a()) + 360.0D) % 360.0F, (float)(this.e[1] * 180.0F / 3.141592653589793D), (float)(this.e[2] * 180.0F / 3.141592653589793D));
      }
    }
    this.jdField_a_of_type_Float = ((float)paramSensorEvent.timestamp);
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_Aljg == null) {
      return;
    }
    this.jdField_a_of_type_Aljg.updateGyroscope(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void d()
  {
    if (SensorManager.getRotationMatrix(this.j, null, this.h, this.g))
    {
      SensorManager.getOrientation(this.j, this.k);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void e()
  {
    float[] arrayOfFloat;
    double d2;
    double d1;
    if ((this.e[0] < -1.570796326794897D) && (this.k[0] > 0.0D))
    {
      this.f[0] = ((float)(0.9980000257492065D * (this.e[0] + 6.283185307179586D) + this.k[0] * 0.001999974F));
      arrayOfFloat = this.f;
      d2 = arrayOfFloat[0];
      if (this.f[0] > 3.141592653589793D)
      {
        d1 = 6.283185307179586D;
        arrayOfFloat[0] = ((float)(d2 - d1));
        label97:
        if ((this.e[1] >= -1.570796326794897D) || (this.k[1] <= 0.0D)) {
          break label493;
        }
        this.f[1] = ((float)(0.9980000257492065D * (this.e[1] + 6.283185307179586D) + this.k[1] * 0.001999974F));
        arrayOfFloat = this.f;
        d2 = arrayOfFloat[1];
        if (this.f[1] <= 3.141592653589793D) {
          break label488;
        }
        d1 = 6.283185307179586D;
        label186:
        arrayOfFloat[1] = ((float)(d2 - d1));
        label194:
        if ((this.e[2] >= -1.570796326794897D) || (this.k[2] <= 0.0D)) {
          break label631;
        }
        arrayOfFloat = this.f;
        d1 = this.e[2];
        arrayOfFloat[2] = ((float)(0.001999974F * this.k[2] + 0.9980000257492065D * (d1 + 6.283185307179586D)));
        arrayOfFloat = this.f;
        d2 = arrayOfFloat[2];
        if (this.f[2] <= 3.141592653589793D) {
          break label626;
        }
        d1 = 6.283185307179586D;
        label289:
        arrayOfFloat[2] = ((float)(d2 - d1));
      }
    }
    for (;;)
    {
      this.l = alji.a(this.f);
      alji.a(this.l, this.m);
      if (this.jdField_a_of_type_Int != 1) {
        super.a(this.m);
      }
      System.arraycopy(this.f, 0, this.e, 0, 3);
      return;
      d1 = 0.0D;
      break;
      if ((this.k[0] < -1.570796326794897D) && (this.e[0] > 0.0D))
      {
        this.f[0] = ((float)(0.998F * this.e[0] + 0.001999974F * (this.k[0] + 6.283185307179586D)));
        arrayOfFloat = this.f;
        d2 = arrayOfFloat[0];
        if (this.f[0] > 3.141592653589793D) {}
        for (d1 = 6.283185307179586D;; d1 = 0.0D)
        {
          arrayOfFloat[0] = ((float)(d2 - d1));
          break;
        }
      }
      this.f[0] = (0.998F * this.e[0] + this.k[0] * 0.001999974F);
      break label97;
      label488:
      d1 = 0.0D;
      break label186;
      label493:
      if ((this.k[1] < -1.570796326794897D) && (this.e[1] > 0.0D))
      {
        this.f[1] = ((float)(0.998F * this.e[1] + 0.001999974F * (this.k[1] + 6.283185307179586D)));
        arrayOfFloat = this.f;
        d2 = arrayOfFloat[1];
        if (this.f[1] > 3.141592653589793D) {}
        for (d1 = 6.283185307179586D;; d1 = 0.0D)
        {
          arrayOfFloat[1] = ((float)(d2 - d1));
          break;
        }
      }
      this.f[1] = (0.998F * this.e[1] + this.k[1] * 0.001999974F);
      break label194;
      label626:
      d1 = 0.0D;
      break label289;
      label631:
      if ((this.k[2] < -1.570796326794897D) && (this.e[2] > 0.0D))
      {
        arrayOfFloat = this.f;
        d1 = 0.998F * this.e[2];
        arrayOfFloat[2] = ((float)(0.001999974F * (this.k[2] + 6.283185307179586D) + d1));
        arrayOfFloat = this.f;
        d2 = arrayOfFloat[2];
        if (this.f[2] > 3.141592653589793D) {}
        for (d1 = 6.283185307179586D;; d1 = 0.0D)
        {
          arrayOfFloat[2] = ((float)(d2 - d1));
          break;
        }
      }
      arrayOfFloat = this.f;
      float f1 = this.e[2];
      arrayOfFloat[2] = (0.001999974F * this.k[2] + 0.998F * f1);
    }
  }
  
  void a()
  {
    this.e[0] = 0.0F;
    this.e[1] = 0.0F;
    this.e[2] = 0.0F;
    this.l[0] = 1.0F;
    this.l[1] = 0.0F;
    this.l[2] = 0.0F;
    this.l[3] = 0.0F;
    this.l[4] = 1.0F;
    this.l[5] = 0.0F;
    this.l[6] = 0.0F;
    this.l[7] = 0.0F;
    this.l[8] = 1.0F;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 4)
    {
      a(paramSensorEvent);
      b(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
    }
    do
    {
      return;
      if (paramSensorEvent.sensor.getType() == 2)
      {
        System.arraycopy(paramSensorEvent.values, 0, this.g, 0, 3);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    } while (paramSensorEvent.sensor.getType() != 1);
    System.arraycopy(paramSensorEvent.values, 0, this.h, 0, 3);
    d();
    a(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aljk
 * JD-Core Version:    0.7.0.1
 */