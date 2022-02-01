package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.so;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import org.json.JSONObject;

public class h
  implements SensorEventListener
{
  static long SbE = 0L;
  static long SbF = 0L;
  static long SbG = 0L;
  static long SbH = 0L;
  static long SbI = 0L;
  static long SbJ = 0L;
  static long SbK = 0L;
  static long SbL = 0L;
  private boolean SbA;
  private IListener<so> SbM;
  private o Sby;
  private Sensor Sbz;
  private SensorManager sensorManager;
  
  public h()
  {
    AppMethodBeat.i(149309);
    this.Sby = null;
    this.SbA = false;
    this.SbM = new PushSportStepDetector.1(this, f.hfK);
    if (com.tencent.mm.compatible.util.d.rb(28))
    {
      Log.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
      this.SbM.alive();
    }
    if ((p.jX(MMApplicationContext.getContext())) && (p.huv())) {}
    for (boolean bool = true;; bool = false)
    {
      this.SbA = bool;
      Log.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.SbA) });
      if (this.SbA) {
        huf();
      }
      SbL = 0L;
      Object localObject = n.Scc;
      localObject = n.hus();
      SbH = ((n.a)localObject).SbH;
      SbI = ((n.a)localObject).SbI;
      SbJ = ((n.a)localObject).SbJ;
      SbK = ((n.a)localObject).SbK;
      SbE = ((n.a)localObject).SbE;
      SbF = ((n.a)localObject).SbF;
      SbG = ((n.a)localObject).SbG;
      if (SbH != p.hut())
      {
        Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid begin time %s", new Object[] { p.iY(SbH) });
        SbH = 0L;
        SbI = 0L;
        SbJ = 0L;
        SbK = 0L;
        SbE = 0L;
        SbF = 0L;
        SbG = 0L;
      }
      AppMethodBeat.o(149309);
      return;
    }
  }
  
  private boolean huf()
  {
    AppMethodBeat.i(149314);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if (this.Sby == null) {
        this.Sby = new o(this);
      }
      if ((this.sensorManager != null) && (MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) && (((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actA, d.a.acti)))
      {
        this.Sbz = this.sensorManager.getDefaultSensor(19);
        if (this.Sbz == null)
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149314);
          return false;
        }
        JSONObject localJSONObject = k.huj();
        boolean bool = this.sensorManager.registerListener(this.Sby, this.Sbz, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          hue();
        }
        Log.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(149314);
        return bool;
      }
      Log.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(149314);
    return false;
  }
  
  static void hug()
  {
    AppMethodBeat.i(263915);
    n.a locala = new n.a();
    locala.SbH = SbH;
    locala.SbI = SbI;
    locala.SbJ = SbJ;
    locala.SbK = SbK;
    locala.SbE = SbE;
    locala.SbF = SbF;
    locala.SbG = SbG;
    n localn = n.Scc;
    n.a(locala);
    AppMethodBeat.o(263915);
  }
  
  public final boolean hud()
  {
    AppMethodBeat.i(149316);
    if ((p.jX(MMApplicationContext.getContext())) && (p.huv())) {}
    for (boolean bool = true;; bool = false)
    {
      this.SbA = bool;
      if (!this.SbA) {
        break;
      }
      hue();
      bool = huf();
      AppMethodBeat.o(149316);
      return bool;
    }
    hue();
    AppMethodBeat.o(149316);
    return false;
  }
  
  final void hue()
  {
    AppMethodBeat.i(149315);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if (this.Sby != null)
      {
        this.sensorManager.unregisterListener(this.Sby);
        this.Sby = null;
      }
      Log.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149315);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149315);
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149310);
    Log.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(paramSensorEvent.values[0]), Long.valueOf(paramSensorEvent.timestamp) });
    if (MMApplicationContext.isMMProcessExist())
    {
      Log.v("MicroMsg.Sport.PushSportStepDetector", "mm process exist, use mm process data");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      com.tencent.threadpool.h.ahAA.g(new i(cn.bDw(), paramSensorEvent.values[0], paramSensorEvent.timestamp, "PUSH"), "PushUpdateStepTag");
      AppMethodBeat.o(149310);
      return;
    }
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      if (paramSensorEvent == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramSensorEvent != null) {
          bool2 = true;
        }
        Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149310);
        return;
      }
    }
    Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Log.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */