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
  private static final float DEFAULT_NEAR_FAR_DIVIDE_RATIO = 3.0F;
  private static final float DEFAULT_NEAR_FAR_MAX_VALUE = 10.0F;
  private static final float DEFAULT_PROXIMITY_TRIGGER = 0.5F;
  private static final String TAG = "MicroMsg.SensorController";
  public static double configNearFarDivideRatio = -1.0D;
  private static float minValue = 4.294967E+009F;
  private static float proximityTrig = 0.5F;
  public static boolean sensorNearFar = false;
  private Context context;
  private boolean isHeadSetPlug;
  private boolean isRegistered;
  private final boolean isSensorEnable;
  private float lastProximity;
  private float lastValue;
  private float maxValue;
  private Sensor proximitySensor;
  private SensorEventCallBack sensorEventCallBack;
  private SensorManager sensorManager;
  
  public SensorController(Context paramContext)
  {
    AppMethodBeat.i(157825);
    this.isHeadSetPlug = false;
    this.isRegistered = false;
    this.maxValue = -1.0F;
    this.lastValue = -1.0F;
    if (paramContext == null)
    {
      this.isSensorEnable = false;
      AppMethodBeat.o(157825);
      return;
    }
    this.context = paramContext;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.proximitySensor = this.sensorManager.getDefaultSensor(8);
    if (this.proximitySensor != null) {
      this.maxValue = Math.min(10.0F, this.proximitySensor.getMaximumRange());
    }
    if (this.maxValue < 0.0F)
    {
      Log.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.maxValue) });
      this.maxValue = 1.0F;
    }
    if (this.proximitySensor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSensorEnable = bool;
      this.lastProximity = (proximityTrig + 1.0F);
      AppMethodBeat.o(157825);
      return;
    }
  }
  
  public boolean hasRegistered()
  {
    return this.isRegistered;
  }
  
  public boolean isSensorEnable()
  {
    return this.isSensorEnable;
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
        this.isHeadSetPlug = true;
      }
      if (i == 0) {
        this.isHeadSetPlug = false;
      }
    }
    AppMethodBeat.o(157829);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(157828);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.proximitySensor == null))
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (this.isHeadSetPlug)
    {
      AppMethodBeat.o(157828);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    Log.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.maxValue), Double.valueOf(3.0D), Double.valueOf(configNearFarDivideRatio), Float.valueOf(this.lastValue), Float.valueOf(this.proximitySensor.getMaximumRange()) });
    if (configNearFarDivideRatio > 0.0D) {
      d = configNearFarDivideRatio;
    }
    if ((configNearFarDivideRatio > 0.0D) || (this.maxValue < 0.0F)) {}
    float f3;
    for (float f1 = this.proximitySensor.getMaximumRange();; f1 = this.maxValue)
    {
      f3 = Math.max(0.1F, (float)(f1 / d));
      Log.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        AppMethodBeat.o(157828);
        return;
      }
    }
    if (this.sensorEventCallBack == null)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 == this.lastValue)
    {
      AppMethodBeat.o(157828);
      return;
    }
    if (f2 < f3)
    {
      Log.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.sensorEventCallBack.onSensorEvent(false);
    }
    for (;;)
    {
      this.lastValue = f2;
      break;
      Log.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.sensorEventCallBack.onSensorEvent(true);
    }
  }
  
  public void removeSensorCallBack()
  {
    AppMethodBeat.i(157827);
    Log.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.sensorManager.unregisterListener(this, this.proximitySensor);
      this.sensorManager.unregisterListener(this);
      this.isRegistered = false;
      this.sensorEventCallBack = null;
      this.lastValue = -1.0F;
      AppMethodBeat.o(157827);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
      }
    }
  }
  
  public void setSensorCallBack(SensorEventCallBack paramSensorEventCallBack)
  {
    AppMethodBeat.i(157826);
    Log.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.isRegistered + ", proximitySensor: " + this.proximitySensor + ", maxValue: " + this.maxValue);
    if (!this.isRegistered)
    {
      this.lastValue = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.sensorManager.registerListener(this, this.proximitySensor, 2);
      this.isRegistered = true;
    }
    this.sensorEventCallBack = paramSensorEventCallBack;
    AppMethodBeat.o(157826);
  }
  
  public static abstract interface SensorEventCallBack
  {
    public abstract void onSensorEvent(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SensorController
 * JD-Core Version:    0.7.0.1
 */