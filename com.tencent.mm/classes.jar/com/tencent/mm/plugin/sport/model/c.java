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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import org.json.JSONObject;

public final class c
  implements SensorEventListener
{
  private Sensor sensor;
  private SensorManager sensorManager;
  private long zoR;
  private long zoS;
  private boolean zoT;
  
  public c()
  {
    AppMethodBeat.i(149294);
    this.zoR = 0L;
    this.zoS = 0L;
    if ((l.gn(ai.getContext())) && (l.dTK())) {}
    for (boolean bool = true;; bool = false)
    {
      this.zoT = bool;
      ac.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.zoT) });
      if (this.zoT) {
        dTV();
      }
      AppMethodBeat.o(149294);
      return;
    }
  }
  
  private boolean dTV()
  {
    AppMethodBeat.i(149297);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (ai.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          ac.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
          AppMethodBeat.o(149297);
          return false;
        }
        JSONObject localJSONObject = h.dUc();
        boolean bool = this.sensorManager.registerListener(this, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool)
        {
          g.agR().agA().set(ah.a.GWC, Integer.valueOf(1));
          dTU();
        }
        for (;;)
        {
          ac.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(149297);
          return bool;
          g.agR().agA().set(ah.a.GWC, Integer.valueOf(0));
        }
        AppMethodBeat.o(149297);
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
    }
    for (;;)
    {
      return false;
      ac.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
    }
  }
  
  public final boolean dTT()
  {
    AppMethodBeat.i(149295);
    if ((l.gn(ai.getContext())) && (l.dTK())) {}
    for (boolean bool = true;; bool = false)
    {
      this.zoT = bool;
      if (!this.zoT) {
        break;
      }
      dTU();
      bool = dTV();
      AppMethodBeat.o(149295);
      return bool;
    }
    dTU();
    AppMethodBeat.o(149295);
    return false;
  }
  
  public final void dTU()
  {
    AppMethodBeat.i(149296);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this);
      ac.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
      AppMethodBeat.o(149296);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
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
      ac.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      if ((Math.abs(l1 - this.zoR) >= 20L) || (System.currentTimeMillis() - this.zoS >= 60000L))
      {
        ac.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        this.zoR = l1;
        this.zoS = System.currentTimeMillis();
        com.tencent.e.h.JZN.f(new c.1(this, l1, l2), "Sport.onSensorChange");
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
        ac.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(149293);
        return;
      }
    }
    ac.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
    paramSensorEvent = paramSensorEvent.values;
    int k = paramSensorEvent.length;
    int i = 0;
    int j = 0;
    while (j < k)
    {
      ac.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(149293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.c
 * JD-Core Version:    0.7.0.1
 */