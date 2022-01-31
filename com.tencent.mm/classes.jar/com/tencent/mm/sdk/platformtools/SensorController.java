package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorController
  extends BroadcastReceiver
  implements SensorEventListener
{
  private static float uie = 4.294967E+009F;
  private static float uig = 0.5F;
  public static boolean uio = false;
  public static double uiq = -1.0D;
  private Context context;
  private float oEK = -1.0F;
  private SensorManager sensorManager;
  private float uif;
  private a uih;
  private Sensor uii;
  private final boolean uij;
  private boolean uik = false;
  public boolean uil = false;
  private float uim = -1.0F;
  
  public SensorController(Context paramContext)
  {
    if (paramContext == null)
    {
      this.uij = false;
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.uii = this.sensorManager.getDefaultSensor(8);
    if (this.uii != null) {
      this.oEK = Math.min(10.0F, this.uii.getMaximumRange());
    }
    if (this.oEK < 0.0F)
    {
      y.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.oEK) });
      this.oEK = 1.0F;
    }
    if (this.uii != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.uij = bool;
      this.uif = (uig + 1.0F);
      return;
    }
  }
  
  public final void a(a parama)
  {
    y.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.uil + ", proximitySensor: " + this.uii + ", maxValue: " + this.oEK);
    if (!this.uil)
    {
      this.uim = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.uii, 2);
      this.uil = true;
    }
    this.uih = parama;
  }
  
  public final void crJ()
  {
    y.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.uii);
      this.sensorManager.unregisterListener(this);
      this.uil = false;
      this.uih = null;
      this.uim = -1.0F;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
      }
    }
  }
  
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
        this.uik = true;
      }
    } while (i != 0);
    this.uik = false;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.uii == null)) {}
    float f2;
    float f1;
    float f3;
    do
    {
      do
      {
        return;
      } while (this.uik);
      f2 = paramSensorEvent.values[0];
      double d = 3.0D;
      y.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.oEK), Double.valueOf(3.0D), Double.valueOf(uiq), Float.valueOf(this.uim), Float.valueOf(this.uii.getMaximumRange()) });
      if (uiq > 0.0D) {
        d = uiq;
      }
      if ((uiq <= 0.0D) && (this.oEK >= 0.0F)) {
        break;
      }
      f1 = this.uii.getMaximumRange();
      f3 = Math.max(0.1F, (float)(f1 / d));
      y.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        return;
      }
    } while ((this.uih == null) || (f2 == this.uim));
    if (f2 < f3)
    {
      y.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.uih.eq(false);
    }
    for (;;)
    {
      this.uim = f2;
      return;
      f1 = this.oEK;
      break;
      y.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.uih.eq(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eq(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */