package com.tencent.mm.pluginsdk.i;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class d$a
  implements SensorEventListener
{
  private static final String LG_E510 = "LG-E510";
  private static final String TAG = "MicroMsg.ShakeSensorListener";
  private static int THREAHOLD = 5;
  private float[] mPrev = new float[3];
  private final float[] mScale = { 2.0F, 2.5F, 0.5F };
  
  static
  {
    if (Build.MODEL.equals("LG-E510")) {
      THREAHOLD = 4;
    }
  }
  
  private float selfAdaptation(float paramFloat)
  {
    if (paramFloat >= 4.0F) {
      ab.v("MicroMsg.ShakeSensorListener", "result:" + paramFloat + " THREAHOLD:" + THREAHOLD);
    }
    if (THREAHOLD >= 9) {}
    int i;
    do
    {
      return paramFloat;
      if (paramFloat >= 14.0F)
      {
        THREAHOLD = 9;
        return paramFloat;
      }
      i = (int)paramFloat;
    } while (THREAHOLD >= i - 4);
    THREAHOLD = i - 4;
    return paramFloat;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public abstract void onRelease();
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = paramSensorEvent.values;
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      arrayOfFloat1[i] = Math.round(this.mScale[i] * (arrayOfFloat2[i] - this.mPrev[i]) * 0.45F);
      if (selfAdaptation(Math.abs(arrayOfFloat1[i])) > THREAHOLD) {
        j = 1;
      }
      this.mPrev[i] = arrayOfFloat2[i];
      i += 1;
    }
    if (j != 0)
    {
      ab.d("MicroMsg.ShakeSensorListener", "sensorChanged " + paramSensorEvent.sensor.getName() + " (" + arrayOfFloat2[0] + ", " + arrayOfFloat2[1] + ", " + arrayOfFloat2[2] + ") diff(" + arrayOfFloat1[0] + " " + arrayOfFloat1[1] + " " + arrayOfFloat1[2] + ")");
      onShake(true);
      onShake(paramSensorEvent.values);
    }
  }
  
  public abstract void onShake(boolean paramBoolean);
  
  public void onShake(float[] paramArrayOfFloat) {}
  
  public void reset()
  {
    ab.d("MicroMsg.ShakeSensorListener", "reset threadHold");
    THREAHOLD = 5;
    if (Build.MODEL.equals("LG-E510")) {
      THREAHOLD = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.d.a
 * JD-Core Version:    0.7.0.1
 */