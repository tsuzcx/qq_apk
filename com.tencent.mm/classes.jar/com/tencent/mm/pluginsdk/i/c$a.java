package com.tencent.mm.pluginsdk.i;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.y;

public abstract class c$a
  implements SensorEventListener
{
  private static int rYs = 5;
  private final float[] rYq = { 2.0F, 2.5F, 0.5F };
  private float[] rYr = new float[3];
  
  static
  {
    if (Build.MODEL.equals("LG-E510")) {
      rYs = 4;
    }
  }
  
  public static void reset()
  {
    y.d("MicroMsg.ShakeSensorListener", "reset threadHold");
    rYs = 5;
    if (Build.MODEL.equals("LG-E510")) {
      rYs = 4;
    }
  }
  
  public abstract void bnY();
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public abstract void onRelease();
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = paramSensorEvent.values;
    int i = 0;
    int j = 0;
    if (i < 3)
    {
      arrayOfFloat1[i] = Math.round(this.rYq[i] * (arrayOfFloat2[i] - this.rYr[i]) * 0.45F);
      float f = Math.abs(arrayOfFloat1[i]);
      if (f >= 4.0F) {
        y.v("MicroMsg.ShakeSensorListener", "result:" + f + " THREAHOLD:" + rYs);
      }
      if (rYs < 9)
      {
        if (f < 14.0F) {
          break label146;
        }
        rYs = 9;
      }
      for (;;)
      {
        if (f > rYs) {
          j = 1;
        }
        this.rYr[i] = arrayOfFloat2[i];
        i += 1;
        break;
        label146:
        int k = (int)f;
        if (rYs < k - 4) {
          rYs = k - 4;
        }
      }
    }
    if (j != 0)
    {
      y.d("MicroMsg.ShakeSensorListener", "sensorChanged " + paramSensorEvent.sensor.getName() + " (" + arrayOfFloat2[0] + ", " + arrayOfFloat2[1] + ", " + arrayOfFloat2[2] + ") diff(" + arrayOfFloat1[0] + " " + arrayOfFloat1[1] + " " + arrayOfFloat1[2] + ")");
      bnY();
      paramSensorEvent = paramSensorEvent.values;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.c.a
 * JD-Core Version:    0.7.0.1
 */