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
  private static float Guf = 4.294967E+009F;
  private static float Guh = 0.5F;
  public static boolean Gun = false;
  public static double Guo = -1.0D;
  private float Gug;
  private a Gui;
  private Sensor Guj;
  private final boolean Guk;
  private boolean Gul;
  private float Gum;
  public boolean aKH;
  private Context context;
  private SensorManager sensorManager;
  private float ylg;
  
  public SensorController(Context paramContext)
  {
    AppMethodBeat.i(157825);
    this.Gul = false;
    this.aKH = false;
    this.ylg = -1.0F;
    this.Gum = -1.0F;
    if (paramContext == null)
    {
      this.Guk = false;
      AppMethodBeat.o(157825);
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.Guj = this.sensorManager.getDefaultSensor(8);
    if (this.Guj != null) {
      this.ylg = Math.min(10.0F, this.Guj.getMaximumRange());
    }
    if (this.ylg < 0.0F)
    {
      ac.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.ylg) });
      this.ylg = 1.0F;
    }
    if (this.Guj != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Guk = bool;
      this.Gug = (Guh + 1.0F);
      AppMethodBeat.o(157825);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157826);
    ac.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.aKH + ", proximitySensor: " + this.Guj + ", maxValue: " + this.ylg);
    if (!this.aKH)
    {
      this.Gum = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.Guj, 2);
      this.aKH = true;
    }
    this.Gui = parama;
    AppMethodBeat.o(157826);
  }
  
  public final void eVS()
  {
    AppMethodBeat.i(157827);
    ac.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.Guj);
      this.sensorManager.unregisterListener(this);
      this.aKH = false;
      this.Gui = null;
      this.Gum = -1.0F;
      AppMethodBeat.o(157827);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
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
        this.Gul = true;
      }
      if (i == 0) {
        this.Gul = false;
      }
    }
    AppMethodBeat.o(157829);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(157828);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.Guj == null))
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (this.Gul)
    {
      AppMethodBeat.o(157828);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    ac.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.ylg), Double.valueOf(3.0D), Double.valueOf(Guo), Float.valueOf(this.Gum), Float.valueOf(this.Guj.getMaximumRange()) });
    if (Guo > 0.0D) {
      d = Guo;
    }
    if ((Guo > 0.0D) || (this.ylg < 0.0F)) {}
    float f3;
    for (float f1 = this.Guj.getMaximumRange();; f1 = this.ylg)
    {
      f3 = Math.max(0.1F, (float)(f1 / d));
      ac.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        AppMethodBeat.o(157828);
        return;
      }
    }
    if (this.Gui == null)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 == this.Gum)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 < f3)
    {
      ac.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.Gui.kc(false);
    }
    for (;;)
    {
      this.Gum = f2;
      break;
      ac.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.Gui.kc(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void kc(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */