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
  private static float IAl = 4.294967E+009F;
  private static float IAn = 0.5F;
  public static boolean IAt = false;
  public static double IAu = -1.0D;
  private float IAm;
  private a IAo;
  private Sensor IAp;
  private final boolean IAq;
  private boolean IAr;
  private float IAs;
  public boolean aMy;
  private Context context;
  private SensorManager sensorManager;
  private float zSX;
  
  public SensorController(Context paramContext)
  {
    AppMethodBeat.i(157825);
    this.IAr = false;
    this.aMy = false;
    this.zSX = -1.0F;
    this.IAs = -1.0F;
    if (paramContext == null)
    {
      this.IAq = false;
      AppMethodBeat.o(157825);
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.IAp = this.sensorManager.getDefaultSensor(8);
    if (this.IAp != null) {
      this.zSX = Math.min(10.0F, this.IAp.getMaximumRange());
    }
    if (this.zSX < 0.0F)
    {
      ae.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.zSX) });
      this.zSX = 1.0F;
    }
    if (this.IAp != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.IAq = bool;
      this.IAm = (IAn + 1.0F);
      AppMethodBeat.o(157825);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157826);
    ae.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.aMy + ", proximitySensor: " + this.IAp + ", maxValue: " + this.zSX);
    if (!this.aMy)
    {
      this.IAs = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.IAp, 2);
      this.aMy = true;
    }
    this.IAo = parama;
    AppMethodBeat.o(157826);
  }
  
  public final void fpx()
  {
    AppMethodBeat.i(157827);
    ae.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.IAp);
      this.sensorManager.unregisterListener(this);
      this.aMy = false;
      this.IAo = null;
      this.IAs = -1.0F;
      AppMethodBeat.o(157827);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
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
        this.IAr = true;
      }
      if (i == 0) {
        this.IAr = false;
      }
    }
    AppMethodBeat.o(157829);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(157828);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.IAp == null))
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (this.IAr)
    {
      AppMethodBeat.o(157828);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    ae.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.zSX), Double.valueOf(3.0D), Double.valueOf(IAu), Float.valueOf(this.IAs), Float.valueOf(this.IAp.getMaximumRange()) });
    if (IAu > 0.0D) {
      d = IAu;
    }
    if ((IAu > 0.0D) || (this.zSX < 0.0F)) {}
    float f3;
    for (float f1 = this.IAp.getMaximumRange();; f1 = this.zSX)
    {
      f3 = Math.max(0.1F, (float)(f1 / d));
      ae.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        AppMethodBeat.o(157828);
        return;
      }
    }
    if (this.IAo == null)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 == this.IAs)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 < f3)
    {
      ae.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.IAo.km(false);
    }
    for (;;)
    {
      this.IAs = f2;
      break;
      ae.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.IAo.km(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void km(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */