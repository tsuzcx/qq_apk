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
  private static float Iga = 4.294967E+009F;
  private static float Igc = 0.5F;
  public static boolean Igi = false;
  public static double Igj = -1.0D;
  private float Igb;
  private a Igd;
  private Sensor Ige;
  private final boolean Igf;
  private boolean Igg;
  private float Igh;
  public boolean aMy;
  private Context context;
  private SensorManager sensorManager;
  private float zBV;
  
  public SensorController(Context paramContext)
  {
    AppMethodBeat.i(157825);
    this.Igg = false;
    this.aMy = false;
    this.zBV = -1.0F;
    this.Igh = -1.0F;
    if (paramContext == null)
    {
      this.Igf = false;
      AppMethodBeat.o(157825);
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.Ige = this.sensorManager.getDefaultSensor(8);
    if (this.Ige != null) {
      this.zBV = Math.min(10.0F, this.Ige.getMaximumRange());
    }
    if (this.zBV < 0.0F)
    {
      ad.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.zBV) });
      this.zBV = 1.0F;
    }
    if (this.Ige != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Igf = bool;
      this.Igb = (Igc + 1.0F);
      AppMethodBeat.o(157825);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157826);
    ad.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.aMy + ", proximitySensor: " + this.Ige + ", maxValue: " + this.zBV);
    if (!this.aMy)
    {
      this.Igh = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.Ige, 2);
      this.aMy = true;
    }
    this.Igd = parama;
    AppMethodBeat.o(157826);
  }
  
  public final void flC()
  {
    AppMethodBeat.i(157827);
    ad.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.Ige);
      this.sensorManager.unregisterListener(this);
      this.aMy = false;
      this.Igd = null;
      this.Igh = -1.0F;
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
        this.Igg = true;
      }
      if (i == 0) {
        this.Igg = false;
      }
    }
    AppMethodBeat.o(157829);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(157828);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.Ige == null))
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (this.Igg)
    {
      AppMethodBeat.o(157828);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    ad.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.zBV), Double.valueOf(3.0D), Double.valueOf(Igj), Float.valueOf(this.Igh), Float.valueOf(this.Ige.getMaximumRange()) });
    if (Igj > 0.0D) {
      d = Igj;
    }
    if ((Igj > 0.0D) || (this.zBV < 0.0F)) {}
    float f3;
    for (float f1 = this.Ige.getMaximumRange();; f1 = this.zBV)
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
    if (this.Igd == null)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 == this.Igh)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 < f3)
    {
      ad.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.Igd.kn(false);
    }
    for (;;)
    {
      this.Igh = f2;
      break;
      ad.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.Igd.kn(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void kn(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */