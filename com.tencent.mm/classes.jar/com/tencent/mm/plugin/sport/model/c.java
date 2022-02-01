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
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

public final class c
  implements SensorEventListener
{
  private long LxK;
  private long LxL;
  private Sensor LxM;
  private boolean LxN;
  private SensorManager sensorManager;
  
  public c()
  {
    AppMethodBeat.i(149294);
    this.LxK = 0L;
    this.LxL = 0L;
    if ((n.ih(MMApplicationContext.getContext())) && (n.gaC())) {}
    for (boolean bool = true;; bool = false)
    {
      this.LxN = bool;
      Log.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.LxN) });
      if (this.LxN) {
        gaO();
      }
      AppMethodBeat.o(149294);
      return;
    }
  }
  
  private static void c(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(221845);
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      if (paramSensorEvent == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramSensorEvent != null) {
          bool2 = true;
        }
        Log.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(221845);
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
    AppMethodBeat.o(221845);
  }
  
  private boolean gaO()
  {
    AppMethodBeat.i(149297);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.LxM = this.sensorManager.getDefaultSensor(19);
        if (this.LxM == null)
        {
          Log.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149297);
          return false;
        }
        JSONObject localJSONObject = k.gaS();
        boolean bool = this.sensorManager.registerListener(this, this.LxM, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool)
        {
          h.aHG().aHp().set(ar.a.VDg, Integer.valueOf(1));
          gaN();
        }
        for (;;)
        {
          Log.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(149297);
          return bool;
          h.aHG().aHp().set(ar.a.VDg, Integer.valueOf(0));
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
  
  public final boolean gaM()
  {
    AppMethodBeat.i(149295);
    if ((n.ih(MMApplicationContext.getContext())) && (n.gaC())) {}
    for (boolean bool = true;; bool = false)
    {
      this.LxN = bool;
      if (!this.LxN) {
        break;
      }
      gaN();
      bool = gaO();
      AppMethodBeat.o(149295);
      return bool;
    }
    gaN();
    AppMethodBeat.o(149295);
    return false;
  }
  
  public final void gaN()
  {
    AppMethodBeat.i(149296);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
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
      if ((Math.abs(l1 - this.LxK) >= 20L) || (System.currentTimeMillis() - this.LxL >= 60000L))
      {
        Log.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, sensorNanoTime %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        this.LxK = l1;
        this.LxL = System.currentTimeMillis();
        paramSensorEvent = new Bundle();
        paramSensorEvent.putLong("lastTickTime", System.currentTimeMillis());
        paramSensorEvent.putLong("lastStep", this.LxK);
        paramSensorEvent.putLong("lastTime", this.LxL);
        j.a(PushProcessIPCService.PROCESS_NAME, paramSensorEvent, g.class, new c.1(this));
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