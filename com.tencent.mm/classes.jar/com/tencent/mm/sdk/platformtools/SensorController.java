package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SensorController
  extends BroadcastReceiver
  implements SensorEventListener
{
  private static float EWT = 4.294967E+009F;
  private static float EWV = 0.5F;
  public static boolean EXb = false;
  public static double EXc = -1.0D;
  private float EWU;
  private a EWW;
  private Sensor EWX;
  private final boolean EWY;
  private boolean EWZ;
  private float EXa;
  public boolean aJR;
  private Context context;
  private SensorManager sensorManager;
  private float wYs;
  
  public SensorController(Context paramContext)
  {
    AppMethodBeat.i(157825);
    this.EWZ = false;
    this.aJR = false;
    this.wYs = -1.0F;
    this.EXa = -1.0F;
    if (paramContext == null)
    {
      this.EWY = false;
      AppMethodBeat.o(157825);
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.EWX = this.sensorManager.getDefaultSensor(8);
    if (this.EWX != null) {
      this.wYs = Math.min(10.0F, this.EWX.getMaximumRange());
    }
    if (this.wYs < 0.0F)
    {
      ad.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.wYs) });
      this.wYs = 1.0F;
    }
    if (this.EWX != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.EWY = bool;
      this.EWU = (EWV + 1.0F);
      AppMethodBeat.o(157825);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157826);
    ad.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.aJR + ", proximitySensor: " + this.EWX + ", maxValue: " + this.wYs);
    if (!this.aJR)
    {
      this.EXa = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.EWX, 2);
      this.aJR = true;
    }
    this.EWW = parama;
    AppMethodBeat.o(157826);
  }
  
  public final void eGx()
  {
    AppMethodBeat.i(157827);
    ad.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.EWX);
      this.sensorManager.unregisterListener(this);
      this.aJR = false;
      this.EWW = null;
      this.EXa = -1.0F;
      AppMethodBeat.o(157827);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
      }
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(157829);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157829);
      return;
    }
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")))
    {
      int i = paramIntent.getIntExtra("state", 0);
      if (i == 1) {
        this.EWZ = true;
      }
      if (i == 0) {
        this.EWZ = false;
      }
    }
    AppMethodBeat.o(157829);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(157828);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.EWX == null))
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (this.EWZ)
    {
      AppMethodBeat.o(157828);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    ad.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.wYs), Double.valueOf(3.0D), Double.valueOf(EXc), Float.valueOf(this.EXa), Float.valueOf(this.EWX.getMaximumRange()) });
    if (EXc > 0.0D) {
      d = EXc;
    }
    if ((EXc > 0.0D) || (this.wYs < 0.0F)) {}
    float f3;
    for (float f1 = this.EWX.getMaximumRange();; f1 = this.wYs)
    {
      f3 = Math.max(0.1F, (float)(f1 / d));
      ad.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        AppMethodBeat.o(157828);
        return;
      }
    }
    if (this.EWW == null)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 == this.EXa)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 < f3)
    {
      ad.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.EWW.jz(false);
    }
    for (;;)
    {
      this.EXa = f2;
      break;
      ad.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.EWW.jz(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void jz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */