package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import org.json.JSONObject;

public final class c
  implements SensorEventListener
{
  private Sensor sensor;
  private SensorManager sensorManager;
  private long ybR;
  private long ybS;
  private boolean ybT;
  
  public c()
  {
    AppMethodBeat.i(149294);
    this.ybR = 0L;
    this.ybS = 0L;
    if ((l.gb(aj.getContext())) && (l.dFj())) {}
    for (boolean bool = true;; bool = false)
    {
      this.ybT = bool;
      ad.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.ybT) });
      if (this.ybT) {
        dFu();
      }
      AppMethodBeat.o(149294);
      return;
    }
  }
  
  private boolean dFu()
  {
    AppMethodBeat.i(149297);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (aj.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          ad.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149297);
          return false;
        }
        JSONObject localJSONObject = h.dFB();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool)
        {
          g.afB().afk().set(ae.a.FxH, Integer.valueOf(1));
          dFt();
        }
        for (;;)
        {
          ad.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(149297);
          return bool;
          g.afB().afk().set(ae.a.FxH, Integer.valueOf(0));
        }
        AppMethodBeat.o(149297);
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
    }
    for (;;)
    {
      return false;
      ad.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
    }
  }
  
  public final boolean dFs()
  {
    AppMethodBeat.i(149295);
    if ((l.gb(aj.getContext())) && (l.dFj())) {}
    for (boolean bool = true;; bool = false)
    {
      this.ybT = bool;
      if (!this.ybT) {
        break;
      }
      dFt();
      bool = dFu();
      AppMethodBeat.o(149295);
      return bool;
    }
    dFt();
    AppMethodBeat.o(149295);
    return false;
  }
  
  public final void dFt()
  {
    AppMethodBeat.i(149296);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ad.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149296);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(149296);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(149293);
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0))
    {
      long l1 = paramSensorEvent.values[0];
      long l2 = paramSensorEvent.timestamp;
      ad.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      if ((Math.abs(l1 - this.ybR) >= 20L) || (System.currentTimeMillis() - this.ybS >= 60000L))
      {
        ad.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        this.ybR = l1;
        this.ybS = System.currentTimeMillis();
        com.tencent.e.h.Iye.f(new c.1(this, l1, l2), "Sport.onSensorChange");
      }
      AppMethodBeat.o(149293);
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
        ad.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149293);
        return;
      }
    }
    ad.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int i = 0;
    int j = 0;
    while (j < k)
    {
      ad.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.c
 * JD-Core Version:    0.7.0.1
 */