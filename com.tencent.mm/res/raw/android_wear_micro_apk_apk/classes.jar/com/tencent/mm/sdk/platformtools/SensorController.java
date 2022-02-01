package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class SensorController
  extends BroadcastReceiver
  implements SensorEventListener
{
  private static float ZT = 4.294967E+009F;
  private static float ZU = 0.5F;
  public static boolean aaa = false;
  public static double aab = -1.0D;
  private p ZV;
  private Sensor ZW;
  private boolean ZX;
  private float ZY;
  private float ZZ;
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
      } while ((paramContext == null) || (!paramContext.equals("android.intent.action.HEADSET_PLUG")));
      i = paramIntent.getIntExtra("state", 0);
      if (i == 1) {
        this.ZX = true;
      }
    } while (i != 0);
    this.ZX = false;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.ZW == null)) {}
    float f2;
    float f1;
    float f3;
    do
    {
      do
      {
        return;
      } while (this.ZX);
      f2 = paramSensorEvent.values[0];
      double d = 3.0D;
      f.c("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.ZY), Double.valueOf(3.0D), Double.valueOf(aab), Float.valueOf(this.ZZ), Float.valueOf(this.ZW.getMaximumRange()) });
      if (aab > 0.0D) {
        d = aab;
      }
      if ((aab <= 0.0D) && (this.ZY >= 0.0F)) {
        break;
      }
      f1 = this.ZW.getMaximumRange();
      f3 = Math.max(0.1F, (float)(f1 / d));
      f.c("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        return;
      }
    } while ((this.ZV == null) || (f2 == this.ZZ));
    if (f2 < f3) {
      f.e("MicroMsg.SensorController", "sensor near-far event near false");
    }
    for (;;)
    {
      this.ZZ = f2;
      return;
      f1 = this.ZY;
      break;
      f.e("MicroMsg.SensorController", "sensor near-far event far true");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */