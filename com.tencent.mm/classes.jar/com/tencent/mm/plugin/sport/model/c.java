package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.PushProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sensitive.d;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import org.json.JSONObject;

public final class c
  implements SensorEventListener
{
  private boolean SbA;
  private long Sbw;
  private long Sbx;
  private o Sby;
  private Sensor Sbz;
  private SensorManager sensorManager;
  
  public c()
  {
    AppMethodBeat.i(149294);
    this.Sbw = 0L;
    this.Sbx = 0L;
    this.Sby = null;
    if ((p.jX(MMApplicationContext.getContext())) && (p.htT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.SbA = bool;
      Log.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.SbA) });
      if (this.SbA) {
        huf();
      }
      AppMethodBeat.o(149294);
      return;
    }
  }
  
  private static void c(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(263902);
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      if (paramSensorEvent == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramSensorEvent != null) {
          bool2 = true;
        }
        Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(263902);
        return;
      }
    }
    Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(263902);
  }
  
  private boolean huf()
  {
    AppMethodBeat.i(149297);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if (this.Sby == null) {
        this.Sby = new o(this);
      }
      if ((this.sensorManager != null) && (MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) && (((d)h.az(d.class)).checkBusinessPermission(d.c.actA, d.a.acti)))
      {
        this.Sbz = this.sensorManager.getDefaultSensor(19);
        if (this.Sbz == null)
        {
          Log.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149297);
          return false;
        }
        JSONObject localJSONObject = k.huj();
        boolean bool = this.sensorManager.registerListener(this.Sby, this.Sbz, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool)
        {
          h.baE().ban().set(at.a.adgb, Integer.valueOf(1));
          hue();
        }
        for (;;)
        {
          Log.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(149297);
          return bool;
          h.baE().ban().set(at.a.adgb, Integer.valueOf(0));
        }
        AppMethodBeat.o(149297);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
    }
    for (;;)
    {
      return false;
      Log.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
    }
  }
  
  public final boolean hud()
  {
    AppMethodBeat.i(149295);
    if ((p.jX(MMApplicationContext.getContext())) && (p.htT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.SbA = bool;
      if (!this.SbA) {
        break;
      }
      hue();
      bool = huf();
      AppMethodBeat.o(149295);
      return bool;
    }
    hue();
    AppMethodBeat.o(149295);
    return false;
  }
  
  public final void hue()
  {
    AppMethodBeat.i(149296);
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
      Log.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149296);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149296);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(149293);
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      long l1 = paramSensorEvent.values[0];
      long l2 = paramSensorEvent.timestamp;
      Log.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      long l3 = cn.bDw();
      if ((Math.abs(l1 - this.Sbw) >= 20L) || (l3 - this.Sbx >= 60000L))
      {
        Log.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, sensorNanoTime %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        this.Sbw = l1;
        this.Sbx = l3;
        paramSensorEvent = new Bundle();
        paramSensorEvent.putLong("lastTickTime", this.Sbx);
        paramSensorEvent.putLong("lastStep", this.Sbw);
        paramSensorEvent.putLong("lastTime", l2);
        j.a(PushProcessIPCService.PROCESS_NAME, paramSensorEvent, g.class, new com.tencent.mm.ipcinvoker.f() {});
      }
      AppMethodBeat.o(149293);
      return;
    }
    c(paramSensorEvent);
    AppMethodBeat.o(149293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.c
 * JD-Core Version:    0.7.0.1
 */