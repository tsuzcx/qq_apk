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
  private static float yqj = 4.294967E+009F;
  private static float yql = 0.5F;
  public static boolean yqs = false;
  public static double yqt = -1.0D;
  private Context context;
  private float rul;
  private SensorManager sensorManager;
  private float yqk;
  private a yqm;
  private Sensor yqn;
  private final boolean yqo;
  private boolean yqp;
  public boolean yqq;
  private float yqr;
  
  public SensorController(Context paramContext)
  {
    AppMethodBeat.i(52265);
    this.yqp = false;
    this.yqq = false;
    this.rul = -1.0F;
    this.yqr = -1.0F;
    if (paramContext == null)
    {
      this.yqo = false;
      AppMethodBeat.o(52265);
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.yqn = this.sensorManager.getDefaultSensor(8);
    if (this.yqn != null) {
      this.rul = Math.min(10.0F, this.yqn.getMaximumRange());
    }
    if (this.rul < 0.0F)
    {
      ab.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.rul) });
      this.rul = 1.0F;
    }
    if (this.yqn != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.yqo = bool;
      this.yqk = (yql + 1.0F);
      AppMethodBeat.o(52265);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(52266);
    ab.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.yqq + ", proximitySensor: " + this.yqn + ", maxValue: " + this.rul);
    if (!this.yqq)
    {
      this.yqr = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.yqn, 2);
      this.yqq = true;
    }
    this.yqm = parama;
    AppMethodBeat.o(52266);
  }
  
  public final void dtJ()
  {
    AppMethodBeat.i(52267);
    ab.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.yqn);
      this.sensorManager.unregisterListener(this);
      this.yqq = false;
      this.yqm = null;
      this.yqr = -1.0F;
      AppMethodBeat.o(52267);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
      }
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(52269);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52269);
      return;
    }
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")))
    {
      int i = paramIntent.getIntExtra("state", 0);
      if (i == 1) {
        this.yqp = true;
      }
      if (i == 0) {
        this.yqp = false;
      }
    }
    AppMethodBeat.o(52269);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(52268);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.yqn == null))
    {
      AppMethodBeat.o(52268);
      return;
    }
    if (this.yqp)
    {
      AppMethodBeat.o(52268);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    ab.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.rul), Double.valueOf(3.0D), Double.valueOf(yqt), Float.valueOf(this.yqr), Float.valueOf(this.yqn.getMaximumRange()) });
    if (yqt > 0.0D) {
      d = yqt;
    }
    if ((yqt > 0.0D) || (this.rul < 0.0F)) {}
    float f3;
    for (float f1 = this.yqn.getMaximumRange();; f1 = this.rul)
    {
      f3 = Math.max(0.1F, (float)(f1 / d));
      ab.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        AppMethodBeat.o(52268);
        return;
      }
    }
    if (this.yqm == null)
    {
      AppMethodBeat.o(52268);
      return;
    }
    if (f2 == this.yqr)
    {
      AppMethodBeat.o(52268);
      return;
    }
    if (f2 < f3)
    {
      ab.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.yqm.hv(false);
    }
    for (;;)
    {
      this.yqr = f2;
      break;
      ab.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.yqm.hv(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */